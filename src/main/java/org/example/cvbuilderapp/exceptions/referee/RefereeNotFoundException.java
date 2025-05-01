package org.example.cvbuilderapp.exceptions.referee;

public class RefereeNotFoundException extends RuntimeException {
    public RefereeNotFoundException(Long id) {
        super("Referee with id " + id + " not found!");
    }
}
