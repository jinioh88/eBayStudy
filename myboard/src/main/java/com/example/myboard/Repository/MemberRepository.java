package com.example.myboard.Repository;

import com.example.myboard.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
    public Member findMemberByEmail(String email);
}
