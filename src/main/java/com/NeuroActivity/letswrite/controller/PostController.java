package com.NeuroActivity.letswrite.controller;

import com.NeuroActivity.letswrite.domain.Post;
import com.NeuroActivity.letswrite.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/posts")
@RestController
public class PostController {
    private final PostRepo postRepo;

    @Autowired
    public PostController(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @GetMapping
    public List<Post> getPosts(){
        return postRepo.findAll();
    }
}
