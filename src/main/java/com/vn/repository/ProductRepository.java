package com.vn.repository;

import com.vn.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("""
        SELECT p
        FROM Product p
        WHERE p.nameProduct LIKE %?1%
    """)
    public Optional<List<Product>> findByNameProduct(String name);

    @Query("""
        SELECT p
        FROM Product p
        WHERE p.id = :id
    """)
    public Optional<Product> findByIdProduct(@Param(value = "id") int id);
}
