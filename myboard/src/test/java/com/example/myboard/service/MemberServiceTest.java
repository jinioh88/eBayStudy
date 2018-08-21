package com.example.myboard.service;

import com.example.myboard.domain.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {
    @Autowired
    MemberService memberService;

    @Test
    public void testAddMEmber() throws Exception {
        Member member = new Member();
        member.setEmail("oh@gmail.com");
        member.setRegdate(LocalDateTime.now());
        member.setPasswd("1234");
        memberService.addMember(member);
        System.out.println(member.getId());
    }

    @Test
    public void testGetMember() throws Exception{
        Member member = memberService.getMember("oh@gmail.com");
    }
}
