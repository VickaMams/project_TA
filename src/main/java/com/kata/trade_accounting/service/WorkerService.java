package com.kata.trade_accounting.service;

import com.kata.trade_accounting.model.Worker;

import java.util.List;

public interface WorkerService {
    List<Worker> findAll();

    Worker getById(long id);

    void save(Worker worker);

    void deleteById(long id);

    Worker findByWorkerName(String name);

    void update(Worker worker);
}
