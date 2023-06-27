package com.example.PetPlanner.mapper;

import com.example.PetPlanner.dto.CommentDto;
import com.example.PetPlanner.model.Comment;
import com.example.PetPlanner.model.User;

public class CommentMapper {

    public static CommentDto convertEntityToDto(Comment comment, User u){
        return CommentDto.builder()
                .id(comment.getId())
                .name(u.getFirstname() + " " + u.getLastname())
                .grade(comment.getGrade())
                .comment(comment.getComment())
                .date(comment.getDateTime())
                .build();
    }
}
