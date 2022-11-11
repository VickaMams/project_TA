package com.kata.trade_accounting.repository;

import com.kata.trade_accounting.model.LawDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LawDetailsRepository extends JpaRepository<LawDetails, Long> {
}
