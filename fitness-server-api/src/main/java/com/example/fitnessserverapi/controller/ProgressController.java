package com.example.fitnessserverapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.example.fitnessserverapi.model.Progress;
import com.example.fitnessserverapi.repository.ProgressRepository;

@RestController
@CrossOrigin(origins = "http://localhost:5173",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, allowedHeaders = "*")
@RequestMapping("/api")
public class ProgressController {

    // Autowire ProgressRepository
    private final ProgressRepository progressRepository;

    @Autowired
    public ProgressController(ProgressRepository progressRepository) {
        this.progressRepository = progressRepository;
    }

    //  retrieve all progress
    @GetMapping("/Progress")
    public ResponseEntity<List<Progress>> getAllWorkout() {
        return ResponseEntity.ok(this.progressRepository.findAll());
    }

    //  create a new progress
    @PostMapping("/CreateProgress")
    public ResponseEntity<Progress> createWorkout(@RequestBody Progress workout) {
        // Save the new progress and return it with status 201 Created
        return ResponseEntity.status(201).body(this.progressRepository.save(workout));
    }

    //  retrieve a progress by its ID
    @GetMapping("/Progress/{id}")
    public ResponseEntity getWorkoutByID(@PathVariable String id) {
        Optional<Progress> optionalProgress = this.progressRepository.findById(id);

        if (optionalProgress.isPresent()) {
            // If the progress is found, return it
            return ResponseEntity.ok(optionalProgress.get());
        } else {
            // If the progress is not found, return a message
            return ResponseEntity.ok("The progress  ID " + id + " was not found");
        }
    }


    // delete a progress by its ID
    @DeleteMapping("/ProgressDelete/{id}")
    public ResponseEntity deleteWorkoutByID(@PathVariable String id) {
        Optional<Progress> optionalProgress = this.progressRepository.findById(id);

        if (optionalProgress.isPresent()) {
            // If the progress is found, delete it and return a success message
            this.progressRepository.deleteById(id);
            return ResponseEntity.ok().body("{\"message\": \"Progress with ID " + id + " deleted successfully\"}");
        } else {
            // If the progress is not found, return a message
            return ResponseEntity.ok().body("{\"message\": \"The Progress with ID " + id + " was not found\"}");
        }
    }


    //  update a progress by its ID
    @PutMapping("/ProgressUp/{id}")
    public ResponseEntity<?> updateWorkout(@PathVariable String id, @RequestBody Progress updatedWorkout) {
        Optional<Progress> optionalWorkout = this.progressRepository.findById(id);
        if (optionalWorkout.isPresent()) {
            // If the progress is found, update its values and return the updated progress
            Progress workout = optionalWorkout.get();
            workout.setWorkoutState(updatedWorkout.getWorkoutState());
            workout.setDescription(updatedWorkout.getDescription());
            workout.setDate(updatedWorkout.getDate());
            workout.setState(updatedWorkout.getState());
            return ResponseEntity.ok(this.progressRepository.save(workout));
        } else {
            // If the progress is not found, return 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }
}
