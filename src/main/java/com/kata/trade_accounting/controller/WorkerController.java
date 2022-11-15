package com.kata.trade_accounting.controller;

import com.kata.trade_accounting.dto.WorkerDto;
import com.kata.trade_accounting.model.Worker;
import com.kata.trade_accounting.service.WorkerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    private final WorkerService workerService;

    private final ModelMapper modelMapper;

    @Autowired
    public WorkerController(WorkerService workerService, ModelMapper modelMapper) {
        this.workerService = workerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public ResponseEntity<List<WorkerDto>> getWorkers() {

        List<WorkerDto> workerDto = workerService.findAll()
                .stream().map(worker -> modelMapper.map(worker, WorkerDto.class))
                .toList();

        return new ResponseEntity<>(workerDto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createWorker(@RequestBody Worker worker) {

        workerService.save(worker);

        return new ResponseEntity<>("Worker successfully created", HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> pageDelete(@PathVariable long id) {

        workerService.deleteById(id);

        return new ResponseEntity<>("Worker successfully deleted", HttpStatus.OK);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<WorkerDto> getWorker(@PathVariable long id) {

        WorkerDto worker = modelMapper.map(workerService.getById(id), WorkerDto.class);

        return new ResponseEntity<>(worker, HttpStatus.OK);
    }

    @GetMapping("getByName/{name}")
    public ResponseEntity<WorkerDto> getWorkerByName(@PathVariable String name) {
        WorkerDto worker = modelMapper.map(workerService.findByWorkerName(name), WorkerDto.class);

        return new ResponseEntity<>(worker, HttpStatus.OK);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<String> editWorker(@PathVariable("id") long id, @RequestBody Worker worker) {
        worker.setId(id);
        workerService.update(worker);

        return new ResponseEntity<>("Worker successfully updated", HttpStatus.OK);
    }

}

