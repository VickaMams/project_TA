package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.CounterAgentDto;
import com.kata.trade_accounting.mapper.CounterAgentMapper;
import com.kata.trade_accounting.repository.CounterAgentRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounterAgentServiceImpl implements CounterAgentService {

    private final CounterAgentRepository repository;
    private final CounterAgentMapper mapper;

    public CounterAgentServiceImpl(CounterAgentRepository repository, CounterAgentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void add(CounterAgentDto dto) {
        repository.saveAndFlush(mapper.dtoToModel(dto));
    }

    public void addAll(List<CounterAgentDto> dtoList) {
        repository.saveAll(mapper.allDtoToModel(dtoList));
    }

    @Override
    public CounterAgentDto getById(Long id) {
        return mapper.modelToDto(repository.findById(id).orElse(null));
    }

    @Override
    public List<CounterAgentDto> getByExample(CounterAgentDto dto) {
        return mapper.allModelsToDto(repository.findAll(Example.of(mapper.dtoToModel(dto))));
    }

    @Override
    public void update(CounterAgentDto dto) {
        if (repository.existsById(dto.getId())) {
            repository.saveAndFlush(mapper.dtoToModel(dto));
        }
    }

    @Override
    public void removeById(Long id) {
        repository.deleteById(id);
    }
}
