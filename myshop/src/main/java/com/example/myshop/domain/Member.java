package com.example.myshop.domain;

import lombok.*;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
    private Long id;
    private String name;
    private String email;
    private String password;
}
