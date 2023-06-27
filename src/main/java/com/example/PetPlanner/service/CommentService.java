package com.example.PetPlanner.service;

import com.example.PetPlanner.dto.CommentDto;
import com.example.PetPlanner.mapper.CommentMapper;
import com.example.PetPlanner.model.Comment;
import com.example.PetPlanner.model.Hotel;
import com.example.PetPlanner.model.ObjectType;
import com.example.PetPlanner.model.VetStation;
import com.example.PetPlanner.repository.CommentRepository;
import com.example.PetPlanner.repository.HotelRepository;
import com.example.PetPlanner.repository.UserRepository;
import com.example.PetPlanner.repository.VetStationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    private final VetStationRepository vetStationRepository;

    private final HotelRepository hotelRepository;

    private final UserRepository userRepository;

    public List<CommentDto> create(Comment comment) {
        comment.setDateTime(LocalDateTime.now());
        Comment c = commentRepository.save(comment);
        if (comment.getObjectType().equals(ObjectType.HOTEL)) {
            Hotel h = hotelRepository.findById(comment.getObjectId()).get();
            h.setAvgGrade(commentRepository.findAvgGradeForObjectId(comment.getObjectId()));
            hotelRepository.save(h);
        }else {
            VetStation v = vetStationRepository.findById(comment.getObjectId()).get();
            v.setAvgGrade(commentRepository.findAvgGradeForObjectId(comment.getObjectId()));
            vetStationRepository.save(v);
        }
        return findByObjectId(c.getId(), ObjectType.VET);
    }

    public Comment findById(Long id) {
        return commentRepository.findById(id).get();
    }

    public List<Comment> findByUserId(Long id, ObjectType status) {
        return commentRepository.findByUserIdAndObjectType(id, status);
    }

    public List<CommentDto> findByObjectId(Long id, ObjectType status) {
        List<Comment> comments = commentRepository.findByObjectIdAndObjectType(id, status);
        List<CommentDto> retVal = new ArrayList<>();
        for (Comment c : comments) {
            retVal.add(CommentMapper.convertEntityToDto(c, userRepository.findById(c.getUserId()).get()));
        }
        return retVal;
    }

    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }
}
