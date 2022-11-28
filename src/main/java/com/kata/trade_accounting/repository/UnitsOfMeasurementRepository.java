package com.kata.trade_accounting.repository;

import com.kata.trade_accounting.model.UnitsOfMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitsOfMeasurementRepository extends JpaRepository<UnitsOfMeasurement, Long> {
    @Modifying
    @Query("update UnitsOfMeasurement set removed = true where id = ?1")
    int setRemovedTrue(Long id);
}
