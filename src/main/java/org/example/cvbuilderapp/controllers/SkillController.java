package org.example.cvbuilderapp.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.cvbuilderapp.dtos.skill.CreateSkillRequest;
import org.example.cvbuilderapp.dtos.skill.SkillDto;
import org.example.cvbuilderapp.dtos.skill.UpdateSkillRequest;
import org.example.cvbuilderapp.services.interfaces.SkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/skills")
@RequiredArgsConstructor
public class SkillController {

    public final SkillService skillService;

    @GetMapping()
    public ResponseEntity<List<SkillDto>> findAll() {
        return ResponseEntity.ok(skillService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(skillService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<SkillDto> create(@Valid @RequestBody CreateSkillRequest request){
        return ResponseEntity.ok(skillService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillDto> update(@PathVariable Long id, @Valid @RequestBody UpdateSkillRequest request){
        skillService.update(id, request);
        return ResponseEntity.ok(skillService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        skillService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
