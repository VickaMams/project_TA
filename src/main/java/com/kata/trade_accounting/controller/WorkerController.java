package com.kata.trade_accounting.controller;

import com.kata.trade_accounting.dto.WorkerDto;
import com.kata.trade_accounting.service.WorkerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/worker")
@Tag(name = "Operation with Worker", description = "Basic crud operation with Worker")
public class WorkerController {

    private final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @Operation(summary = "Get all existing Worker")
    @Tag(name = "Operation with Worker")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Got information about all existing Worker",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = WorkerDto.class)))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Worker not found", content = @Content)
            })
    @GetMapping("/")
    public ResponseEntity<List<WorkerDto>> getWorkers() {
        return new ResponseEntity<>(workerService.findAll(), HttpStatus.OK);
    }


    @Operation(summary = "Get all existing Worker")
    @Tag(name = "Operation with Worker")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Got information about all existing Worker",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = WorkerDto.class)))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Worker not found", content = @Content)
            })
    @PostMapping("/create")
    public ResponseEntity<String> createWorker(@RequestBody WorkerDto workerDto) {

        workerService.save(workerDto);

        return new ResponseEntity<>("Worker successfully created", HttpStatus.OK);
    }

    @Operation(summary = "Get all existing Worker")
    @Tag(name = "Operation with Worker")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Got information about all existing Worker",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = WorkerDto.class)))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Worker not found", content = @Content)
            })
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> pageDelete(@PathVariable long id) {

        workerService.deleteById(id);

        return new ResponseEntity<>("Worker successfully deleted", HttpStatus.OK);
    }

    @Operation(summary = "Get all existing Worker")
    @Tag(name = "Operation with Worker")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Got information about all existing Worker",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = WorkerDto.class)))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Worker not found", content = @Content)
            })
    @GetMapping("getById/{id}")
    public ResponseEntity<WorkerDto> getWorker(@PathVariable long id) {

        return new ResponseEntity<>(workerService.getById(id), HttpStatus.OK);
    }


    @Operation(summary = "Get all existing Worker")
    @Tag(name = "Operation with Worker")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Got information about all existing Worker",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = WorkerDto.class)))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Worker not found", content = @Content)
            })
    @PutMapping("edit/{id}")
    public ResponseEntity<String> editWorker(@PathVariable("id") long id, @RequestBody WorkerDto workerDto) {
        workerService.update(id, workerDto);

        return new ResponseEntity<>("Worker successfully updated", HttpStatus.OK);
    }

}

