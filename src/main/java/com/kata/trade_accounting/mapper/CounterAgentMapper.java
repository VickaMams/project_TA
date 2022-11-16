package com.kata.trade_accounting.mapper;

import com.kata.trade_accounting.dto.CounterAgentDto;
import com.kata.trade_accounting.model.CounterAgent;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CounterAgentMapper {
    private final ModelMapper mapper;

    public CounterAgentMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public CounterAgentDto modelToDto(CounterAgent model) {
        return mapper.map(model, CounterAgentDto.class);
    }

    public CounterAgent dtoToModel(CounterAgentDto dto) {
        return mapper.map(dto, CounterAgent.class);
    }

    public List<CounterAgent> allDtoToModel(List<CounterAgentDto> dtoList) {
        List<CounterAgent> modelList = new ArrayList<>();
        for (CounterAgentDto dto : dtoList) {
            modelList.add(dtoToModel(dto));
        }

        return modelList;
    }

    public List<CounterAgentDto> allModelsToDto(List<CounterAgent> modelList) {
        List<CounterAgentDto> dtoList = new ArrayList<>();
        for (CounterAgent model : modelList) {
            dtoList.add(modelToDto(model));
        }

        return dtoList;
    }

}
