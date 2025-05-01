package org.example.cvbuilderapp.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.cvbuilderapp.dtos.resume.CreateResumeRequest;
import org.example.cvbuilderapp.dtos.resume.ResumeDto;
import org.example.cvbuilderapp.dtos.resume.UpdateResumeRequest;
import org.example.cvbuilderapp.services.interfaces.ResumeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/resumes")
@RequiredArgsConstructor
public class ResumeController {

    public final ResumeService resumeService;

    @GetMapping
    public ResponseEntity<List<ResumeDto>> findAll() {
        return ResponseEntity.ok(resumeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResumeDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(resumeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ResumeDto> create(@Valid @RequestBody CreateResumeRequest request) {
        return ResponseEntity.ok(resumeService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResumeDto> update(@PathVariable Long id, @Valid @RequestBody UpdateResumeRequest request) {
        resumeService.update(id, request);
        return ResponseEntity.ok(resumeService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        resumeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
