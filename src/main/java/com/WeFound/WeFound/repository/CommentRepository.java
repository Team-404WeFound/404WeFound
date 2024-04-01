package com.WeFound.WeFound.repository;

import com.WeFound.WeFound.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
