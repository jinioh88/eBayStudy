package com.example.myshop.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter @Getter
@ToString(exclude = "member")
@Table(name = "tbl_profile")
@EqualsAndHashCode(of = "pname")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno;
    private String pname;
    private boolean current;

    @ManyToOne
    private Member member;
}
