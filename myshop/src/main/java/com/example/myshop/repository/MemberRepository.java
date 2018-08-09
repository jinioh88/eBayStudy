package com.example.myshop.repository;

import com.example.myshop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member,Long> {
    public long countByNameContains(String name);

    @Query("select count(m) form Member m where m.name = :name")
    public Long countAllByName(@Param("name")String name);
}
