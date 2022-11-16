package com.kata.trade_accounting.controller;

import com.kata.trade_accounting.dto.CounterAgentDto;
import com.kata.trade_accounting.service.CounterAgentService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CounterAgentController {

    private final CounterAgentService counterAgentService;

    public CounterAgentController(CounterAgentService counterAgentService) {
        this.counterAgentService = counterAgentService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CounterAgentDto dto) {
        counterAgentService.add(dto);
    }

    @GetMapping("/getById/{id}")
    public CounterAgentDto getById(@PathVariable Long id) {
        return counterAgentService.getById(id);
    }

    @GetMapping("/get")
    public List<CounterAgentDto> getByExample(@RequestBody CounterAgentDto dto) {
        return counterAgentService.getByExample(dto);
    }

    @PostMapping("/update")
    public void update(@RequestBody CounterAgentDto dto) {
        counterAgentService.update(dto);
    }

    @DeleteMapping("/remove/{id}")
    public void removeById(@PathVariable Long id) {
        counterAgentService.removeById(id);
    }

}
