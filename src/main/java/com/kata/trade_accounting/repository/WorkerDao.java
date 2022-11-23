package com.kata.trade_accounting.repository;

import com.kata.trade_accounting.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerDao extends JpaRepository<Worker, Long> {
    Worker findWorkerByName(String name);
}
