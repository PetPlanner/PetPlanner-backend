package com.example.PetPlanner.repository;

import com.example.PetPlanner.model.AnswerOnTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerOnTopicRepository extends JpaRepository<AnswerOnTopic, Long> {
    List<AnswerOnTopic> findByTopicId(Long id);
}
