package de.joe.springboottrainer;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 *
 * @author JoeDeDev
 */
@Primary
@Component("localManager")
public class InMemoryTrainingManager implements TrainingManager,  InitializingBean{

    private List<Training> storedTrainings;

    public InMemoryTrainingManager() {
         this.storedTrainings = new ArrayList<>();
    }
    
@PostConstruct
public void demoData(){
   save(Training.withLocation("Remote").withTopic("Spring").withTrainer("Johannes").build());
   System.out.println("DemoData");
    }

@PreDestroy
public void predestroy(){
    System.out.println("PreDestroy!");
}
    
    @Override
    public Training save(Training training) {
        storedTrainings.add(training);
        return training;
    }

    @Override
    public List<Training> findAll() {
        return storedTrainings;
    }

    @Override
    public List<String> findLocations() {
        return storedTrainings.stream().map(t -> t.getLocation()).toList();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("AfterPropertySet");
    }

}
