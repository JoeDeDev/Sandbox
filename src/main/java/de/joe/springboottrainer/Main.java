package de.joe.springboottrainer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author JoeDeDev
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        TrainingController controller = context.getBean(TrainingController.class);
        
        controller.add(Training.withTopic("SpringContext").withLocation("Remote").withTrainer("Johannes").build());
        controller.handle(args);
        context.close();
    }

}
