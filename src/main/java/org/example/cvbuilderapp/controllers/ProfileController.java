package org.example.cvbuilderapp.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.cvbuilderapp.dtos.profile.CreateProfileRequest;
import org.example.cvbuilderapp.dtos.profile.ProfileDto;
import org.example.cvbuilderapp.dtos.profile.UpdateProfileRequest;
import org.example.cvbuilderapp.services.interfaces.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/profiles")
@RequiredArgsConstructor
public class ProfileController {

    public final ProfileService profileService;


    @GetMapping
    public ResponseEntity<List<ProfileDto>> findAll() {
        return ResponseEntity.ok(profileService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(profileService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProfileDto> create(@Valid @RequestBody CreateProfileRequest request) {
        return ResponseEntity.ok(profileService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfileDto> update(@PathVariable Long id, @Valid @RequestBody UpdateProfileRequest request) {
        profileService.update(id, request);
        return ResponseEntity.ok(profileService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        profileService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
