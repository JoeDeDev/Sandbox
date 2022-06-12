package de.joe.springboottrainer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

/**
 *
 * @author JoeDeDev
 */
@Qualifier("persistent")
public class JdbcTrainingManager implements TrainingManager {


   private final JdbcTemplate jdbcTemplate;

   public JdbcTrainingManager(JdbcTemplate jdbcTemplate) {
       this.jdbcTemplate = jdbcTemplate;
   }
   

   @Override
   public Training save(Training training) {

       SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
            .withTableName("TBL_TRAININGS")
            .usingGeneratedKeyColumns("COL_ID");
      Number key = insert.executeAndReturnKey(
            Map.of("COL_TOPIC", training.getTopic(),
                  "COL_LOCATION", training.getLocation(),
                  "COL_TRAINER_NAME", training.getTrainer().getName()));
      training.setId(key.intValue());
      return training;
   }

   @Override
   public List<Training> findAll() {
      List<Training> trainings = new ArrayList<>();
      String query = "SELECT COL_ID, COL_LOCATION, COL_TOPIC, COL_TRAINER_NAME FROM TBL_TRAININGS";
      return jdbcTemplate.query(query, new RowMapper<Training>() {
         @Override
         public Training mapRow(ResultSet rs, int rowNum) throws SQLException {
            Training training = Training.withLocation(rs.getString(2)).withTopic(rs.getString(3)).withTrainer(rs.getString(4)).build();
            training.setId(rs.getInt(1));
            return training;
         }
      });
   }

   @Override
   public List<String> findLocations() {
      List<String> locations = new ArrayList<>();
      String query = "SELECT DISTINCT COL_LOCATION FROM TBL_TRAININGS";
      return jdbcTemplate.queryForStream(query, (rs, i)-> rs.getString(1)).collect(Collectors.toList());

   }  
}
