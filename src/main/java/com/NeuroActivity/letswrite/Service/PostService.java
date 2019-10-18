package com.NeuroActivity.letswrite.Service;

import com.NeuroActivity.letswrite.domain.Post;
import com.NeuroActivity.letswrite.repository.PostRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepo postRepo;

    @Autowired
    public PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public List<Post> getAllPost(){
        return postRepo.findAll();
    }

    public Post getById(long id){
        return postRepo.getOne(id);
    }

    public Post createPost(Post post){
        return postRepo.save(post);
    }

    public Post updatePost(long id, Post post){
        return postRepo.findById(id).map(dbPost -> {
            //ToDo Be careful with code belong.
            BeanUtils.copyProperties(post, dbPost, "id");
            return postRepo.save(dbPost);
        }).orElseGet(()->{
            post.setId(id);
            return postRepo.save(post);
        });
    }

    public void deletePost(Post post){
        postRepo.delete(post);
    }

}
