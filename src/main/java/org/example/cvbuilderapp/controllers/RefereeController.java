package org.example.cvbuilderapp.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.cvbuilderapp.dtos.referee.CreateRefereeRequest;
import org.example.cvbuilderapp.dtos.referee.RefereeDto;
import org.example.cvbuilderapp.dtos.referee.UpdateRefereeRequest;
import org.example.cvbuilderapp.services.interfaces.RefereeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/referees")
@RequiredArgsConstructor
public class RefereeController {
    public final RefereeService refereeService;

    @GetMapping
    public ResponseEntity<List<RefereeDto>> findAll(){
        return ResponseEntity.ok(refereeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RefereeDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(refereeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<RefereeDto> create(@Valid @RequestBody CreateRefereeRequest request){
        return ResponseEntity.ok(refereeService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RefereeDto> update(@PathVariable Long id, @Valid @RequestBody UpdateRefereeRequest request){
        refereeService.update(id,request);
        return ResponseEntity.ok(refereeService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        refereeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
