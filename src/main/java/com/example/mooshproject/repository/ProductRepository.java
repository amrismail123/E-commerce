package com.example.mooshproject.repository;

import com.example.mooshproject.entity.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>{
    @EntityGraph(attributePaths = "category")
    List<Product>findByCategoryId(Long id);

    @EntityGraph(attributePaths = "category")
    @Query("select p from Product p")
    List<Product>findAllWithCategory();
}

