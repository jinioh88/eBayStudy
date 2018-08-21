package com.example.myboard.service.impl;

import com.example.myboard.Repository.MemberRepository;
import com.example.myboard.domain.Member;
import com.example.myboard.domain.MemberRole;
import com.example.myboard.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberRepository repository;

    @Override
    @Transactional
    public Long addMember(Member member) {
        PasswordEncoder passwordEncoder =
                PasswordEncoderFactories
                        .createDelegatingPasswordEncoder();

        String encodePasswd = passwordEncoder.encode(member.getPasswd());
        MemberRole memberRole = new MemberRole();
        memberRole.setName("USER");
        member.addMemberROle(memberRole);

        // member가 영속성이 부여도리때 memberRole도 영속성이 부여되야 한다.
        repository.save(member);
        return member.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public Member getMember(String email) {

        return repository.findMemberByEmail(email);
    }
}
