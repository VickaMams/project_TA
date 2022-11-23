package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.WorkerDto;
import com.kata.trade_accounting.model.Worker;

import java.util.List;

public interface WorkerService {
    List<WorkerDto> findAll();

    WorkerDto getById(long id);

     WorkerDto save(WorkerDto workerDto);

    void deleteById(long id);

    WorkerDto findByWorkerName(String name);

    WorkerDto update(Long id, WorkerDto workerDto);
}
