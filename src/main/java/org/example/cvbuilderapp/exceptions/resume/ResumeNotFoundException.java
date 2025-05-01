package org.example.cvbuilderapp.exceptions.resume;

public class ResumeNotFoundException extends RuntimeException {
    public ResumeNotFoundException(Long id) {
        super("Resume with id " + id + " not found!");
    }
}
