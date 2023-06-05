package com.example.PetPlanner.repository;

import com.example.PetPlanner.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByUserId(Long id);
    List<Comment> findByHotelId(Long id);
}
