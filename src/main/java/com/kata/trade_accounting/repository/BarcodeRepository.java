package com.kata.trade_accounting.repository;

import com.kata.trade_accounting.model.Barcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BarcodeRepository extends JpaRepository<Barcode, Long> {

    @Modifying
    @Query("update Barcode set removed = true where id = ?1")
    int setRemovedTrue(Long id);
}
