package de.joe.springboottrainer;

import lombok.Data;

/**
 *
 * @author JoeDeDev
 * 
 * Lombok anntotation is used for constructing this data class.
 * @Data - Getter and setter are added automatically while building.
 */
public @Data class Employee {

    private String name;

    public Employee(String name) {
        this.name = name;
    }
    
    @Override
    public String toString(){
        return name;
    
    }
    
    
}
