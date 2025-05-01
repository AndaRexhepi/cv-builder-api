package org.example.cvbuilderapp.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.cvbuilderapp.dtos.objective.CreateObjectiveRequest;
import org.example.cvbuilderapp.dtos.objective.ObjectiveDto;
import org.example.cvbuilderapp.dtos.objective.UpdateObjectiveRequest;
import org.example.cvbuilderapp.services.interfaces.ObjectiveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/objectives")
@RequiredArgsConstructor
public class ObjectiveController {

    public final ObjectiveService objectiveService;

    @GetMapping
    public ResponseEntity<List<ObjectiveDto>> findAll() {
        return ResponseEntity.ok(objectiveService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObjectiveDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(objectiveService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ObjectiveDto> create(@Valid @RequestBody CreateObjectiveRequest objectiveDto) {
        return ResponseEntity.ok(objectiveService.create(objectiveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObjectiveDto> update(@PathVariable Long id, @Valid @RequestBody UpdateObjectiveRequest objectiveDto) {
        objectiveService.update(id, objectiveDto);
        return ResponseEntity.ok(objectiveService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        objectiveService.delete(id);
        return ResponseEntity.ok().build();
    }
}
