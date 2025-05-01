package org.example.cvbuilderapp.exceptions.pursuit;

public class PursuitNotFoundException extends RuntimeException {
    public PursuitNotFoundException(Long id) {
        super("Pursuit with id " + id + " not found!");
    }
}
