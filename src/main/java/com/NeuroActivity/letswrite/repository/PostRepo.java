package com.NeuroActivity.letswrite.repository;

import com.NeuroActivity.letswrite.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
}
