package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.WorkerDto;
import com.kata.trade_accounting.exception.LawDetailsNotFoundException;
import com.kata.trade_accounting.exception.WorkerNotFoundException;
import com.kata.trade_accounting.mapper.WarehouseMapper;
import com.kata.trade_accounting.mapper.WorkerMapper;
import com.kata.trade_accounting.model.LawDetails;
import com.kata.trade_accounting.model.Worker;
import com.kata.trade_accounting.repository.WorkerDao;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class WorkerServiceImpl implements WorkerService {

    private final WorkerDao workerDAO;
    private final WorkerMapper mapper;

    public WorkerServiceImpl(WorkerDao workerDAO, WorkerMapper mapper) {
        this.workerDAO = workerDAO;
        this.mapper = mapper;
    }


    @Override
    @Nullable
    public List<WorkerDto> findAll() throws ResponseStatusException {
        return workerDAO.findAll()
                .stream().map(mapper::toDto).toList();
    }

    @Override
    @Nullable
    public WorkerDto getById(long id) {
        Optional<Worker> worker = workerDAO.findById(id);
        if (worker.isPresent()) {
            return mapper.toDto(worker.get());
        } else {
            throw new WorkerNotFoundException(String.format("Worker with id=%s not found", id));
        }
    }

    @Transactional
    @Override
    public WorkerDto save(WorkerDto workerDto) {
        Worker entity = workerDAO.save(mapper.toEntity(workerDto));
        entity.setRemoved(false);
        return mapper.toDto(entity);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        int i = workerDAO.setRemovedTrue(id);
        if (i == 0) {
            throw new WorkerNotFoundException(String.format("Worker with id=%s not found", id));
        }
    }

    @Override
    public WorkerDto findByWorkerName(String name) {
        WorkerDto workerDto = workerDAO.findWorkerByName(name);
        log.info("Worker with #name={} successfully find", name);
        return workerDto ;
    }

    @Transactional
    @Override
    public WorkerDto update(Long id, WorkerDto workerDto) {
        Optional<Worker> worker= workerDAO.findById(id);
        if (worker.isPresent()) {
            workerDto.setId(id);
            return save(workerDto);
        } else {
            throw new LawDetailsNotFoundException(String.format("Worker with id=%s not found", id));
        }
    }
}
