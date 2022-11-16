package com.kata.trade_accounting.service;

import com.kata.trade_accounting.model.CounterAgent;
import com.kata.trade_accounting.repository.CounterAgentRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounterAgentServiceImpl implements CounterAgentService {

    private final CounterAgentRepository repository;

    public CounterAgentServiceImpl(CounterAgentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(CounterAgent counterAgent) {
        repository.saveAndFlush(counterAgent);
    }

    public void addAll(List<CounterAgent> counterAgents) {
        repository.saveAll(counterAgents);
    }

    @Override
    public CounterAgent getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<CounterAgent> getAllByExample(CounterAgent counterAgent) {
        return repository.findAll(Example.of(counterAgent));
    }

    @Override
    public void update(CounterAgent counterAgent) {
        if (repository.existsById(counterAgent.getId())) {
            repository.saveAndFlush(counterAgent);
        }
    }

    @Override
    public void removeById(Long id) {
        repository.deleteById(id);
    }
}
