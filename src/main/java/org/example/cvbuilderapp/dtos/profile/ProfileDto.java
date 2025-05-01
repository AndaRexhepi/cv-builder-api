package org.example.cvbuilderapp.dtos.profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cvbuilderapp.entities.Resume;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {
    private Long id;
    private String profileImage;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private String zipCode;
    private String country;
    private Resume resume;
}
