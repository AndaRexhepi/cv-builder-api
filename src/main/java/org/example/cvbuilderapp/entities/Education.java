package org.example.cvbuilderapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "educations")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "degree", nullable = false, length=100)
    @Size(max = 100)
    @NotNull
    private String degree;

    @Column(name = "school", nullable = false, length=100)
    @Size(max = 100)
    @NotNull
    private String school;

    @Column(name = "gpa")
    private Float gpa;

    @Column(name = "start_date")
    @PastOrPresent
    private LocalDate startDate;

    @Column(name = "end_date")
    @FutureOrPresent
    private LocalDate endDate;

    @Column(name = "description", length = 1000)
    @Size(max = 1000)
    private String description;

    @Column(name = "is_present")
    private Boolean isPresent;

    @ManyToOne
    @Cascade({CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "resume_id")
    private Resume resume;
}

