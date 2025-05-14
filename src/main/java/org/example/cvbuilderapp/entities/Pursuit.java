package org.example.cvbuilderapp.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "pursuits")
public class Pursuit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pursuit", nullable = false, length = 100)
    @Size(max = 100)
    @NotNull
    private String pursuit;

    @ManyToOne
    @Cascade({CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "resume_id")
    @JsonManagedReference
    private Resume resume;
}

