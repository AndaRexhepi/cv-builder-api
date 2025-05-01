package org.example.cvbuilderapp.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.cvbuilderapp.dtos.pursuit.CreatePursuitRequest;
import org.example.cvbuilderapp.dtos.pursuit.PursuitDto;
import org.example.cvbuilderapp.dtos.pursuit.UpdatePursuitRequest;
import org.example.cvbuilderapp.services.interfaces.PursuitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pursuits")
@RequiredArgsConstructor
public class PursuitController {

    public final PursuitService pursuitService;

    @GetMapping
    public ResponseEntity<List<PursuitDto>> findAll() {
        return ResponseEntity.ok(pursuitService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PursuitDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(pursuitService.findById(id));
    }


    @PostMapping
    public ResponseEntity<PursuitDto> create(@Valid @RequestBody CreatePursuitRequest pursuitDto) {
        return ResponseEntity.ok(pursuitService.create(pursuitDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PursuitDto> update(@PathVariable Long id, @Valid @RequestBody UpdatePursuitRequest pursuitDto) {
        pursuitService.update(id, pursuitDto);
        return ResponseEntity.ok(pursuitService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pursuitService.delete(id);
        return ResponseEntity.ok().build();
    }
}
