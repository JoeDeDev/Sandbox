package de.joe.springboottrainer;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author JoeDeDev
 * @Configuration Spring container configuration class
 * @CompenentScan - scan the project for classes using the '@Component'-annotiation
 * 
 */
@Configuration
@ComponentScan
public class AppConfiguration {

    static final String DB_URL = "jdbc:mariadb://127.0.0.1/training";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "acbbaber";

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSource DataSource() {
        return new DriverManagerDataSource(DB_URL, DB_USER, DB_PASSWORD);
    }

    @Qualifier("persistent")
    @Bean
    public JdbcTrainingManager JdbcTrainingManager(JdbcTemplate jdbcTemplate) {
        return new JdbcTrainingManager(jdbcTemplate);
    }

}
