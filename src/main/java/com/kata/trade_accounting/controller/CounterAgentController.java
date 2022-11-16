package com.kata.trade_accounting.controller;

import com.kata.trade_accounting.dto.CounterAgentDto;
import com.kata.trade_accounting.mapper.CounterAgentMapper;
import com.kata.trade_accounting.service.CounterAgentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/counterAgent")
public class CounterAgentController {

    private final CounterAgentService counterAgentService;
    private final CounterAgentMapper mapper;

    public CounterAgentController(CounterAgentService counterAgentService, CounterAgentMapper mapper) {
        this.counterAgentService = counterAgentService;
        this.mapper = mapper;
    }

    @ApiOperation(value = "addCounterAgent", notes = "Adds a counter agent", nickname = "addCounterAgent")
    @PostMapping("/add")
    public void add(@RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody(
            required = true, description = "A counter agent to be added") CounterAgentDto counterAgent) {
        counterAgentService.add(mapper.dtoToModel(counterAgent));
    }

    @ApiOperation(value = "getCounterAgentById", notes = "Gets a counter agent by ID", nickname = "getCounterAgent")
    @GetMapping("/getById/{id}")
    public ResponseEntity<CounterAgentDto> getById(@ApiParam(value = "Id", required = true) @PathVariable Long id) {
        CounterAgentDto dto = mapper.modelToDto(counterAgentService.getById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @ApiOperation(value = "getCounterAgentsByExample", notes = "Gets counter agents by Example", nickname = "getCounterAgentExample")
    @GetMapping("/get")
    public ResponseEntity<List<CounterAgentDto>> getAllByExample(@RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody(
            required = true, description = "Example of counter agent used for search") CounterAgentDto dto) {
        List<CounterAgentDto> dtoList = mapper.allModelsToDto(counterAgentService.getAllByExample(mapper.dtoToModel(dto)));
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @ApiOperation(value = "updateCounterAgent", notes = "Updates a counter agent", nickname = "updateCounterAgent")
    @PostMapping("/update")
    public void update(@RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description =
            "A counter agent that needs to be updated") CounterAgentDto dto) {
        counterAgentService.update(mapper.dtoToModel(dto));
    }

    @ApiOperation(value = "removeCounterAgentById", notes = "Removes counter agent by ID", nickname = "removeCounterAgent")
    @DeleteMapping("/remove/{id}")
    public void removeById(@ApiParam(value = "Id", required = true) @PathVariable Long id) {
        counterAgentService.removeById(id);
    }

}
