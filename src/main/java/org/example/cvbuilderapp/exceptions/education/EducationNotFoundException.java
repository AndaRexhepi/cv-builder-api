package org.example.cvbuilderapp.exceptions.education;

public class EducationNotFoundException extends RuntimeException {
    public EducationNotFoundException(Long id) {
        super("Education with id " + id + " not found!");
    }
}
