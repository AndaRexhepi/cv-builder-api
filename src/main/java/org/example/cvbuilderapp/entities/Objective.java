package org.example.cvbuilderapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "resume_id")
    @JsonIgnore
    private Resume resume;
}

