package com.kata.trade_accounting.repository;

import com.kata.trade_accounting.model.CounterAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterAgentRepository extends JpaRepository<CounterAgent, Long> {

}
