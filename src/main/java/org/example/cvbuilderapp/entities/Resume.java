package org.example.cvbuilderapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "resumes")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @OneToOne(mappedBy = "resume", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private Profile profile;

    @OneToOne(mappedBy = "resume", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private Objective objective;

    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Education> education;

    @OneToMany(mappedBy = "resume",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Experience> experience;

    @OneToMany(mappedBy = "resume",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Skill> skill;

    @OneToMany(mappedBy = "resume",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Pursuit> pursuit;

    @OneToMany(mappedBy = "resume",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Referee> reference;

    @OneToMany(mappedBy = "resume",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Accolade> accolade;
}

