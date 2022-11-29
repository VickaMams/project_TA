package com.kata.trade_accounting.repository;

import com.kata.trade_accounting.model.LegalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegalEntityDao extends JpaRepository<LegalEntity, Long> {
}
