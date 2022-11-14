package com.kata.trade_accounting.mapper;

import com.kata.trade_accounting.dto.CounterAgentDTO;
import com.kata.trade_accounting.model.CounterAgent;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.w3c.dom.css.Counter;

@Service
public class CounterAgentMapper {
    private ModelMapper mapper;

    public CounterAgentMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public CounterAgentDTO modelToDto(CounterAgent model) {
        return mapper.map(model, CounterAgentDTO.class);
    }

    public CounterAgent dtoToModel(CounterAgentDTO dto) {
        return mapper.map(dto, CounterAgent.class);
    }
}
