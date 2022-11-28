package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.CounterAgentDto;
import com.kata.trade_accounting.exception.CounterAgentNotFoundException;
import com.kata.trade_accounting.mapper.CounterAgentMapper;
import com.kata.trade_accounting.model.CounterAgent;
import com.kata.trade_accounting.repository.CounterAgentRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CounterAgentServiceImpl implements CounterAgentService {

    private final CounterAgentRepository repository;
    private final CounterAgentMapper mapper;

    public CounterAgentServiceImpl(CounterAgentRepository repository, CounterAgentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void add(CounterAgentDto counterAgent) {
        repository.saveAndFlush(mapper.dtoToModel(counterAgent));
    }

    public void addAll(List<CounterAgentDto> counterAgents) {
        repository.saveAll(mapper.allDtoToModel(counterAgents));
    }

    @Override
    public CounterAgentDto getById(Long id) {
        Optional<CounterAgent> optional = repository.findById(id);
        if (optional.isPresent()) {
            return mapper.modelToDto(optional.get());
        } else {
            throw new CounterAgentNotFoundException("Could not find a counter agent with such id (" + id + ")");
        }
    }

    @Override
    public List<CounterAgentDto> getAllByExample(CounterAgentDto counterAgent) {
        return mapper.allModelsToDto(repository.findAll(Example.of(mapper.dtoToModel(counterAgent))));
    }

    @Override
    public void update(CounterAgentDto counterAgent) {
        if (repository.existsById(counterAgent.getId())) {
            repository.saveAndFlush(mapper.dtoToModel(counterAgent));
        } else {
            throw new CounterAgentNotFoundException("Could not update counter agent: does not exist (id " + counterAgent.getId() + ")");
        }
    }

    @Override
    public void removeById(Long id)   {
        Optional<CounterAgent> optional = repository.findById(id);
        if (optional.isPresent()) {
            optional.get().setRemoved(true);
        } else {
            throw new CounterAgentNotFoundException("Could not find counter agent with such id (" + id + ")");
        }
    }
}
