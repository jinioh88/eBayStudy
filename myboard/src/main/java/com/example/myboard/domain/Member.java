package com.example.myboard.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String passwd;

    @CreationTimestamp
    @Column(name = "reg_date")
    private LocalDateTime regdate;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<MemberRole> memberRoles = new ArrayList<>();

    // 헬퍼
    public void addMemberROle(MemberRole role) {
        memberRoles.add(role);
        if(role.getMember()!=this)
            role.setMember(this);
    }
}
