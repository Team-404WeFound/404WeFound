package com.WeFound.WeFound.repository;

import com.WeFound.WeFound.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface LikeRepoitory extends JpaRepository<Like,Long> {
    void deleteByUserLoginIdAndBoardId(Long user_id, Long question_id);
    Boolean existsByUserLoginIdAndBoardId(Long user_id, Long question_id);
    List<Like> findAllByUserLoginId(Long user_id);
}
