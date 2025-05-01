package org.example.cvbuilderapp.exceptions.user;

public class UserAlreadyExistsException extends IllegalArgumentException {
    public UserAlreadyExistsException(String email) {
        super("User with email " + email + " already exists");
    }
}
