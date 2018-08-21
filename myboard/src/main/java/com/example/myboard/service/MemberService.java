package com.example.myboard.service;

import com.example.myboard.domain.Member;

public interface MemberService {
    Long addMember(Member member);
    Member getMember(String email);
}
