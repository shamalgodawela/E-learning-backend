package com.example.fitnessserverapi.repository;

import com.example.fitnessserverapi.model.StudyGroup;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.Optional;

public interface StudyGroupRepository extends MongoRepository<StudyGroup, String> {
    Optional<StudyGroup> findById(String id);
}
