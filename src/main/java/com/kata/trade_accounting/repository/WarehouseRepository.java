package com.kata.trade_accounting.repository;

import com.kata.trade_accounting.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    @Modifying
    @Query("update Warehouse set removed = true where id = ?1")
    int setRemovedTrue(Long id);
}
