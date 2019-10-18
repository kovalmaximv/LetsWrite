package com.NeuroActivity.letswrite.controller;

import com.NeuroActivity.letswrite.domain.Comment;
import com.NeuroActivity.letswrite.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/comment")
@RestController
public class CommentController {
    private final CommentRepo commentRepo;

    @Autowired
    public CommentController(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    @GetMapping
    public List<Comment> getAllComment(){
        return commentRepo.findAll();
    }

    @GetMapping("{id}")
    public Comment getComment(@PathVariable Long id){
        return commentRepo.getOne(id);
    }

    @PostMapping
    public Comment createComment(@RequestBody Comment comment){
        return commentRepo.save(comment);
    }
}
