package com.example.myshop.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pName;
    private String pPrice;
    private int pCount;
}
