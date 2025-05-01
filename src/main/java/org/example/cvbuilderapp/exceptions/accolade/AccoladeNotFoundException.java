package org.example.cvbuilderapp.exceptions.accolade;

public class AccoladeNotFoundException extends RuntimeException {
    public AccoladeNotFoundException(Long id) {
        super("Accolade with id " + id + " not found!");
    }
}
