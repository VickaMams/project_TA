package com.kata.trade_accounting.controller;

import com.kata.trade_accounting.dto.CounterAgentDto;
import com.kata.trade_accounting.service.CounterAgentService;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    public CounterAgentController(CounterAgentService counterAgentService) {
        this.counterAgentService = counterAgentService;
    }

    @PostMapping("/add")
    @ApiResponses( value = @ApiResponse(responseCode = "200", description = "Addded counteragent"))
    @Operation(summary = "Add a counteragent")
    public void add(@RequestBody
                    @io.swagger.v3.oas.annotations.parameters.RequestBody(
                            required = true, description = "A counter agent to be added")
                    CounterAgentDto counterAgent) {
        counterAgentService.add(counterAgent);
    }


    @GetMapping("/getById/{id}")
    @Operation(summary = "Get a counteragent by Id")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Counteragent information", content = @Content),
            @ApiResponse(responseCode = "404", description = "Counteragent not found")
    } )
    public ResponseEntity<CounterAgentDto> getById(@ApiParam(value = "Id", required = true)
                                                   @PathVariable
                                                   Long id) {
        CounterAgentDto dto = counterAgentService.getById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


    @GetMapping("/get")
    @Operation(description = "Return a list of counteragents")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "List of counteragents", content = @Content)
    } )
    public ResponseEntity<List<CounterAgentDto>> getAllByExample(@RequestBody
                                                                 @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                                         required = true, description = "Example of counter agent used for search")
                                                                 CounterAgentDto dto) {
        List<CounterAgentDto> dtoList = counterAgentService.getAllByExample(dto);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }


    @PostMapping("/update")
    @Operation(description = "Update a given counteragent")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Counteragent updated"),
            @ApiResponse(responseCode = "404", description = "Could not update: no such counteragent")
    } )
    public void update(@RequestBody
                       @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description =
                               "A counter agent that needs to be updated")
                       CounterAgentDto dto) {
        counterAgentService.update(dto);
    }


    @DeleteMapping("/remove/{id}")
    @Operation(description = "Flag counteragent record for deletion")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Counteragent removed"),
            @ApiResponse(responseCode = "404", description = "Could not remove: no such counteragent")
    } )
    public void removeById(@ApiParam(value = "Id", required = true)
                           @PathVariable
                           Long id) {
        counterAgentService.removeById(id);
    }

}
