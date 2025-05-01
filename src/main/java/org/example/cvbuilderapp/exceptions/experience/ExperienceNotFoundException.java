package org.example.cvbuilderapp.exceptions.experience;

public class ExperienceNotFoundException extends RuntimeException {

    public ExperienceNotFoundException(Long id) {
        super("Experience with id " + id + " not found!");
    }
}
