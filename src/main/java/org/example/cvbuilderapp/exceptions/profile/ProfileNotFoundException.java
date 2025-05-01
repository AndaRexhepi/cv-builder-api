package org.example.cvbuilderapp.exceptions.profile;

public class ProfileNotFoundException extends RuntimeException {
    public ProfileNotFoundException(Long id) {
        super("Profile with id " + id + " not found!");
    }
}
