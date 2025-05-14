package org.example.cvbuilderapp.entities;

import jakarta.persistence.*;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "accolades")
public class Accolade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "accolade", nullable = false, length = 100)
    @Size(max = 100)
    @NotNull
    private String accolade;

    @Column(name = "organization", nullable = false, length = 100)
    @Size(max = 100)
    @NotNull
    private String organization;

    @Column(name = "description", length = 1000)
    @Size(max = 1000)
    private String description;

    @Column(name = "issue_date")
    @PastOrPresent
    private LocalDate issueDate;

    @ManyToOne
    @Cascade({CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "resume_id")
    private Resume resume;


}

