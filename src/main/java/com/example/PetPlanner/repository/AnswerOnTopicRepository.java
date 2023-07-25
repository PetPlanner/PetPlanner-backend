package com.example.PetPlanner.repository;

import com.example.PetPlanner.model.AnswerOnTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerOnTopicRepository extends JpaRepository<AnswerOnTopic, Long> {
    List<AnswerOnTopic> findByTopicId(Long id);
    @Query("select count(a.id) from AnswerOnTopic a where a.topicId = :topicId")
    int countAnswer(@Param("topicId")Long topicId);
}
