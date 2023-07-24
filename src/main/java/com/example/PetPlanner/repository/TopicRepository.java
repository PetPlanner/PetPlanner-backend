package com.example.PetPlanner.repository;

import com.example.PetPlanner.model.Topic;
import com.example.PetPlanner.model.TopicStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {


    List<Topic> findAllByStatus(TopicStatus status);
}
