package com.kata.trade_accounting.service;

import com.kata.trade_accounting.model.CounterAgent;

import java.util.List;

public interface CounterAgentService {

    void add(CounterAgent counterAgent);

    CounterAgent getById(Long id);

    List<CounterAgent> getAllByExample(CounterAgent dto);

    void update(CounterAgent dto);

    void removeById(Long id);
}
