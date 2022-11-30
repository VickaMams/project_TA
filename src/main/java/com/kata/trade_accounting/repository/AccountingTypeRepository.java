package com.kata.trade_accounting.repository;

import com.kata.trade_accounting.model.AccountingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountingTypeRepository extends JpaRepository<AccountingType, Long> {

    Optional<AccountingType> findByProductId(Long id);

    @Modifying
    @Query("update AccountingType set removed = true where id = ?1")
    int setRemovedTrue(Long id);

}
