package com.kata.trade_accounting.repository;

import com.kata.trade_accounting.model.TypeOfProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfProductDao extends JpaRepository<TypeOfProduct, Long> {
}
