
package de.joe.springboottrainer;

import java.util.List;

/**
 *
 * @author joe
 */
public interface TrainingManager {
    
    Training save(Training training);
    
    List<Training> findAll();

    List<String> findLocations();
    
    
    
    
    
}
