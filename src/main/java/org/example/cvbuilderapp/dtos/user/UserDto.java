package org.example.cvbuilderapp.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cvbuilderapp.entities.Resume;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private List<Long> resumeIds;
}
