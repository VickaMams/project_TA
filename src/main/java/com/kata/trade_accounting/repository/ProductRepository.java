package com.kata.trade_accounting.repository;

import com.kata.trade_accounting.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Modifying
    @Query("update Product set removed = true where id = ?1")
    int setRemovedTrue(Long id);
}
