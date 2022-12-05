package com.kata.trade_accounting.repository;

import com.kata.trade_accounting.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    @Modifying
    @Query("update Country set removed = true where id = ?1")
    int setRemovedTrue(Long id);
}
