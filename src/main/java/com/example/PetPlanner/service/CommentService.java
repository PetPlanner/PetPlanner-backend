package com.example.PetPlanner.service;

import com.example.PetPlanner.model.Comment;
import com.example.PetPlanner.model.ObjectType;
import com.example.PetPlanner.repository.CommentRepository;
import com.example.PetPlanner.repository.HotelRepository;
import com.example.PetPlanner.repository.VetStationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    private final VetStationRepository vetStationRepository;

    private final HotelRepository hotelRepository;

    public Comment create(Comment comment) {
        comment.setDateTime(LocalDateTime.now());
        Comment c = commentRepository.save(comment);
        if (comment.getObjectType().equals(ObjectType.HOTEL))
            hotelRepository.findById(comment.getObjectId()).get().setAvgGrade(commentRepository.findAvgGradeForObjectId(comment.getObjectId()));
        else
            vetStationRepository.findById(comment.getObjectId()).get().setAvgGrade(commentRepository.findAvgGradeForObjectId(comment.getObjectId()));

        return c;
    }

    public Comment findById(Long id) {
        return commentRepository.findById(id).get();
    }

    public List<Comment> findByUserId(Long id, ObjectType status) {
        return commentRepository.findByUserIdAndObjectType(id, status);
    }

    public List<Comment> findByObjectId(Long id) {
        return commentRepository.findByObjectId(id);
    }

    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }
}
