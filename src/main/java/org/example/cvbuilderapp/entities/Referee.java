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
@Entity(name = "referees")
public class Referee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false, length = 100)
    @Size(max = 100)
    @NotNull
    private String fullName;

    @Column(name = "relationship", length = 100)
    @Size(max = 100)
    private String relationship;

    @Column(name = "job_title", nullable = false,length = 100)
    @Size(max = 100)
    @NotNull
    private String jobTitle;

    @Column(name = "company", length = 100)
    @Size(max = 100)
    private String description;

    @ManyToOne
    @Cascade({CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "resume_id")
    @JsonManagedReference
    private Resume resume;
}

