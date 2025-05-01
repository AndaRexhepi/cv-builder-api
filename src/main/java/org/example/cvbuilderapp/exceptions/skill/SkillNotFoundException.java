package org.example.cvbuilderapp.exceptions.skill;

public class SkillNotFoundException extends RuntimeException {
    public SkillNotFoundException(Long id) {
        super("Skill with id " + id + " not found!");
    }
}
