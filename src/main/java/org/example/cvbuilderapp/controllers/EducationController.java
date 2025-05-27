package org.example.cvbuilderapp.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.cvbuilderapp.dtos.education.CreateEducationRequest;
import org.example.cvbuilderapp.dtos.education.EducationDto;
import org.example.cvbuilderapp.dtos.education.UpdateEducationRequest;
import org.example.cvbuilderapp.services.interfaces.EducationService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/educations")
@RequiredArgsConstructor
public class EducationController {
    public final EducationService educationService;

    @GetMapping
    public ResponseEntity<List<EducationDto>> findAll() {
        return ResponseEntity.ok(educationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(educationService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EducationDto> create(@Valid @RequestBody CreateEducationRequest request) {
        return ResponseEntity.ok(educationService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EducationDto> update(@PathVariable Long id, @Valid @RequestBody UpdateEducationRequest request) {
        educationService.update(id, request);
        return ResponseEntity.ok(educationService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        educationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
