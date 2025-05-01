package org.example.cvbuilderapp.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.cvbuilderapp.dtos.experience.CreateExperienceRequest;
import org.example.cvbuilderapp.dtos.experience.ExperienceDto;
import org.example.cvbuilderapp.dtos.experience.UpdateExperienceRequest;
import org.example.cvbuilderapp.services.interfaces.ExperienceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/experiences")
@RequiredArgsConstructor
public class ExperienceController {
    public final ExperienceService experienceService;

    @GetMapping
    public ResponseEntity<List<ExperienceDto>> findAll() {
        return ResponseEntity.ok(experienceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienceDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(experienceService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ExperienceDto> create(@Valid @RequestBody CreateExperienceRequest experienceDto) {
        return ResponseEntity.ok(experienceService.create(experienceDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExperienceDto> update(@PathVariable Long id, @Valid @RequestBody UpdateExperienceRequest experienceDto) {
        experienceService.update(id, experienceDto);
        return ResponseEntity.ok(experienceService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        experienceService.delete(id);
        return ResponseEntity.ok().build();
    }
}
