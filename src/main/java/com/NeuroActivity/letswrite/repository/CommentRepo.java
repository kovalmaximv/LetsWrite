package com.NeuroActivity.letswrite.repository;

import com.NeuroActivity.letswrite.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
