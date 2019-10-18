package com.NeuroActivity.letswrite.controller;

import com.NeuroActivity.letswrite.Service.PostService;
import com.NeuroActivity.letswrite.domain.Post;
import com.NeuroActivity.letswrite.repository.PostRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/posts")
@RestController
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getPosts(){
        return postService.getAllPost();
    }

    @GetMapping("{id}")
    public Post getOnePost(@PathVariable long id){
       return postService.getById(id);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post){
        return postService.createPost(post);
    }

    @PutMapping("{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post){
        return postService.updatePost(id, post);
    }

    @DeleteMapping
    public void deletePost(@RequestBody Post post){
        postService.deletePost(post);
    }
}
