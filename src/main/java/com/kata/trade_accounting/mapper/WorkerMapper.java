package com.kata.trade_accounting.mapper;

import com.kata.trade_accounting.dto.WorkerDto;
import com.kata.trade_accounting.model.Worker;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class WorkerMapper {
    private final ModelMapper mapper;

    public WorkerMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public WorkerDto toDto(Worker worker) {
        return mapper.map(worker, WorkerDto.class);
    }

    public Worker toEntity(WorkerDto dto) {
        return mapper.map(dto, Worker.class);
    }
}
