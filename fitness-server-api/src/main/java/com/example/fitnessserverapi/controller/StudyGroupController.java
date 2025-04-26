package com.example.fitnessserverapi.controller;


import com.example.fitnessserverapi.model.StudyGroup;
import com.example.fitnessserverapi.repository.StudyGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, allowedHeaders = "*")
@RequestMapping("/api/groups")

public class StudyGroupController {

    @Autowired
    private StudyGroupRepository studyGroupRepository;

    // Create group
    @PostMapping("/create")
    public ResponseEntity<StudyGroup> createGroup(@RequestBody StudyGroup group) {
        StudyGroup savedGroup = studyGroupRepository.save(group);
        return ResponseEntity.ok(savedGroup);
    }

    // Rea
    @GetMapping("/getallGorups")
    public ResponseEntity<List<StudyGroup>> getAllGroups() {
        return ResponseEntity.ok(studyGroupRepository.findAll());
    }

    // Get group
    @GetMapping("/{id}")
    public ResponseEntity<?> getGroupById(@PathVariable String id) {
        Optional<StudyGroup> group = studyGroupRepository.findById(id);
        return group.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update group
    @PutMapping("/{id}")
    public ResponseEntity<?> updateGroup(@PathVariable String id, @RequestBody StudyGroup updatedGroup) {
        return studyGroupRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedGroup.getName());
                    existing.setDescription(updatedGroup.getDescription());
                    existing.setMentor(updatedGroup.getMentor());
                    existing.setMembers(updatedGroup.getMembers());
                    return ResponseEntity.ok(studyGroupRepository.save(existing));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete group
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable String id) {
        if (studyGroupRepository.existsById(id)) {
            studyGroupRepository.deleteById(id);
            return ResponseEntity.ok("Group deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
