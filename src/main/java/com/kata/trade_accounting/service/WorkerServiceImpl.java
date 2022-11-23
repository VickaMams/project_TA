package com.kata.trade_accounting.service;

import com.kata.trade_accounting.model.Worker;
import com.kata.trade_accounting.repository.WorkerDao;
import lombok.extern.slf4j.Slf4j;
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

    public WorkerServiceImpl(WorkerDao workerDAO) {
        this.workerDAO = workerDAO;
    }


    @Override
    @Nullable
    public List<Worker> findAll() throws ResponseStatusException {
        List<Worker> workers = workerDAO.findAll();
        if (!workers.isEmpty()) {
            log.info("Getting list of workers");
            return workers;
        } else {
            log.info("List workers is empty");
            //need custom http status code
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @Nullable
    public Worker getById(long id) {
        Optional<Worker> worker = workerDAO.findById(id);
        if (worker.isPresent()) {
            log.info("Workers with id #id={} is found", id);
            return worker.get();
        } else {
            log.info("Worker with id #id={} not found", id);
            //need custom http status code
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Transactional
    @Override
    public void save(Worker worker) {
        workerDAO.save(worker);
        log.info("Worker with #id={} successfully saved", worker.getId());
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        workerDAO.deleteById(id);
        log.info("Worker with #id={} successfully deleted", id);
    }

    @Override
    public Worker findByWorkerName(String name) {
        Worker worker = workerDAO.findWorkerByName(name);
        log.info("Worker with #name={} successfully find", name);
        return worker;
    }

    @Transactional
    @Override
    public void update(Worker worker) {
        workerDAO.save(worker);
        log.info("Worker with #id={} successfully updated", worker.getId());
    }
}
