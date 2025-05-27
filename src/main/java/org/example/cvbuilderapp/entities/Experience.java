package org.example.cvbuilderapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
import java.time.YearMonth;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "experiences")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    @Size(max = 100)
    @NotNull
    private String title;

    @Column(name = "company", nullable = false, length = 100)
    @Size(max = 100)
    @NotNull
    private String company;

    @Column(name = "employment_type", nullable = false, length = 100)
    @Size(max = 100)
    @NotNull
    private String employmentType;

    @Column(name = "location", length = 100)
    @Size(max = 100)
    private String location;

    @Column(name = "description", length = 1000)
    @Size(max = 1000)
    private String description;

    @Column(name = "start_date")
    @PastOrPresent
    private LocalDate startDate;

    @Column(name = "end_date")
    @FutureOrPresent
    private LocalDate endDate;

    @Column(name = "is_present")
    private boolean isPresent;

    @ManyToOne
    @Cascade({CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "resume_id")
    @JsonIgnore
    private Resume resume;

}

