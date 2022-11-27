package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.CounterAgentDto;

import java.util.List;

public interface CounterAgentService {

    void add(CounterAgentDto counterAgent);

    CounterAgentDto getById(Long id);

    List<CounterAgentDto> getAllByExample(CounterAgentDto dto);

    void update(CounterAgentDto dto);

    void removeById(Long id);
}
