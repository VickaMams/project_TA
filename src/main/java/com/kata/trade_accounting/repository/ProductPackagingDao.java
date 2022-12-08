package com.kata.trade_accounting.repository;


import com.kata.trade_accounting.model.ProductPackaging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface ProductPackagingDao extends JpaRepository<ProductPackaging, Long> {
}
