package com.kata.trade_accounting.repository;

import com.kata.trade_accounting.dto.WorkerDto;
import com.kata.trade_accounting.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerDao extends JpaRepository<Worker, Long> {
    WorkerDto findWorkerByName(String name);

    @Modifying
    @Query("update Worker set removed = true where id = ?1")
    int setRemovedTrue(Long id);
}
