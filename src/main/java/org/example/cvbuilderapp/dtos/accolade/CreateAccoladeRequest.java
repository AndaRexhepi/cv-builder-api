package org.example.cvbuilderapp.dtos.accolade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cvbuilderapp.entities.Resume;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccoladeRequest {
    private String accolade;
    private String organization;
    private String description;
    private LocalDate issueDate;
    private Resume resume;
}
