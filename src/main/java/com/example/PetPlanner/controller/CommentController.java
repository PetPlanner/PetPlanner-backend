package com.example.PetPlanner.controller;

import com.example.PetPlanner.model.Comment;
import com.example.PetPlanner.model.ObjectType;
import com.example.PetPlanner.model.Pet;
import com.example.PetPlanner.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity create(@RequestBody Comment comment) {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.create(comment));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.findById(id));
    }

    @GetMapping("/user/{id}/status/{status}")
    public ResponseEntity findByUserId(@PathVariable Long id, @PathVariable ObjectType status) {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.findByUserId(id,status));
    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity findByHotelId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.findByObjectId(id));
    }

    @DeleteMapping("id")
    public ResponseEntity deleteById(@PathVariable Long id) {
        commentService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted.");
    }

}
