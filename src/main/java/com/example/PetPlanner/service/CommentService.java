package com.example.PetPlanner.service;

import com.example.PetPlanner.model.Comment;
import com.example.PetPlanner.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment create(Comment comment){
        return commentRepository.save(comment);
    }

    public Comment findById(Long id){
        return commentRepository.findById(id).get();
    }

    public List<Comment> findByUserId(Long id){
        return commentRepository.findByUserId(id);
    }

    public List<Comment> findByHotelId(Long id){
        return commentRepository.findByHotelId(id);
    }

    public void deleteById(Long id){
        commentRepository.deleteById(id);
    }
}
