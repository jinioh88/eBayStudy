package com.example.myshop;

import com.example.myshop.domain.Member;
import com.example.myshop.repository.MemberRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MyshopApplicationTests {

	@Autowired
	MemberRepository repository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void nullTest() {
		Assert.assertNotNull(repository);
	}

	@Test
	public void testSaveMember() {
		Member member = new Member();
		member.setId(21L);
		member.setEmail("jinioh88@gmail.com");
		member.setName("oh");
		member.setPassword("1111");

		repository.save(member);
		System.out.println(member.getId());

		Member member2 = repository.getOne(1L);
		if(member==member2)
			System.out.println("같다");
	}
}
