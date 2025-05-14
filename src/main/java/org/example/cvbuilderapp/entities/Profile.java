package org.example.cvbuilderapp.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "profiles")
public class Profile{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "profile_image", length = 1000)
    @Size(max = 1000)
    private String profileImage;

    @Column(name = "first_name", nullable = false, length = 100)
    @Size(min = 2, max = 100, message = "First name must be between 2 and 100 characters")
    @NotNull
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    @Size(min = 2, max = 100, message = "Last name must be between 2 and 100 characters")
    @NotNull
    private String lastName;

    @Column(name = "email", nullable = false, length = 100)
    @Size(min = 2, max = 100, message = "Email must be between 2 and 100 characters")
    @NotNull
    private String email;

    @Column(name = "phone_number", length = 20)
    @Size(max = 20)
    private String phoneNumber;

    @Column(name = "address", length = 100)
    @Size(max = 100)
    private String address;

    @Column(name = "city", length = 100)
    @Size(max = 100)
    private String city;

    @Column(name = "zip_code", length = 10)
    @Size(max = 10)
    private String zipCode;

    @Column(name = "country", length = 100)
    @Size(max = 100)
    private String country;

    @Column(name = "nationality", length = 100)
    @Size(max = 100)
    private String nationality;

    @Column(name = "birthdate")
    @PastOrPresent(message = "Birthdate must be in the past or present")
    private Date birthdate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "resume_id")
    @JsonManagedReference
    private Resume resume;
}

