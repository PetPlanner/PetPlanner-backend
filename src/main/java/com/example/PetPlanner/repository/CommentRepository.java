package com.example.PetPlanner.repository;

import com.example.PetPlanner.model.Comment;
import com.example.PetPlanner.model.ObjectType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByUserIdAndObjectType(Long id, ObjectType objectType);
    List<Comment> findByObjectIdAndObjectType(Long id, ObjectType objectType);
    @Query("select avg(grade) from Comment c where  c.objectId = :id")
    float findAvgGradeForObjectId(@Param("id") Long id);
}
