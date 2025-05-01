package org.example.cvbuilderapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "objectives")
public class Objective {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "objective",length = 500)
    @Size(max = 500)
    private String objective;

    @OneToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
}

