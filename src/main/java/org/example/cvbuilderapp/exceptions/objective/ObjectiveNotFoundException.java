package org.example.cvbuilderapp.exceptions.objective;

public class ObjectiveNotFoundException extends RuntimeException {

    public ObjectiveNotFoundException(Long id) {
        super("Objective with id " + id + " not found!");
    }
}
