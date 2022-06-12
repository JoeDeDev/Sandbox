package de.joe.springboottrainer;


import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author JoeDeDev
 */

@Component
public class TrainingController {
   private TrainingManager manager;

   public TrainingController(TrainingManager trainingManager) {
      manager = trainingManager;
   }

   public void handle(String[] args) {

      if (args.length > 0 && args[0].equalsIgnoreCase("locations")) {
         outputLocations(manager.findLocations());
      } else {
         manager.findAll().forEach(s -> output(s));
      }
   }

   private void outputLocations(List<String> locations) {
      System.out.println("Alle Locations:");
      locations.forEach(System.out::println);
   }

   private void output(Training s) {
      System.out.printf("%s - Ort: %s mit Trainer %s %n", s.getTopic(), s.getLocation(), s.getTrainer(), s.getId());
   }

   public void add(Training training) {
      manager.save(training);
   }
}