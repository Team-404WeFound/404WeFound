package com.WeFound.WeFound.repository;

import com.WeFound.WeFound.entity.PremiumQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremiumQuestionRepository extends JpaRepository<PremiumQuestion, Long> {
}