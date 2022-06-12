package de.joe.springboottrainer;

/**
 * This class can be instantiated by builder pattern.
 * @author JoeDeDev
 */
public class Training {

    private int id;
    private String topic;
    private String location;
    private Employee trainer;

    public Training() {
    }

    public static TrainingBuilder withLocation(String location) {
        return new TrainingBuilder().withLocation(location);
    }

    public static TrainingBuilder withTopic(String topic) {
        return new TrainingBuilder().withTopic(topic);
    }

    public static TrainingBuilder withTrainer(String trainer) {
        return new TrainingBuilder().withTrainer(trainer);
    }

    public static Training build() {
        return new TrainingBuilder().build();
    }


// <editor-fold defaultstate="collapsed" desc="Getter/Setter">


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Employee getTrainer() {
        return trainer;
    }

    public void setTrainer(Employee trainer) {
        this.trainer = trainer;
    }


    
    
// </editor-fold>

    public static class TrainingBuilder {

        Training training = new Training();

        public TrainingBuilder withLocation(String location) {
            training.location = location;
            return this;
        }

        public TrainingBuilder withTopic(String topic) {
            training.topic = topic;
            return this;
        }

        public TrainingBuilder withTrainer(String trainer) {
            training.trainer = new Employee(trainer);
            return this;
        }
        
        public Training build(){
            return training;
        }
    }

}
