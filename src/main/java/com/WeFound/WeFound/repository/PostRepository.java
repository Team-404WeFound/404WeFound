package com.WeFound.WeFound.repository;

import com.WeFound.WeFound.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
