package com.NeuroActivity.letswrite.repository;

import com.NeuroActivity.letswrite.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
