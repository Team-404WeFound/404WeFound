package com.WeFound.WeFound.repository;


import com.WeFound.WeFound.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // 이메일로 회원 정보 조회 아직 미구현
    Optional<MemberEntity> findByMemberEmail(String memberEmail);
}