package com.example.myshop.repository;

import com.example.myshop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
//    @Query("select p from Product p where b.pName = :pName")
//    public List<Product> product(@Param("pName") String pName);
}
