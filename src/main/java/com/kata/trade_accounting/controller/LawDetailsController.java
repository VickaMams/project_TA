package com.kata.trade_accounting.controller;

import com.kata.trade_accounting.dto.LawDetailsDTO;
import com.kata.trade_accounting.mapper.LawDetailsMapper;
import com.kata.trade_accounting.model.LawDetails;
import com.kata.trade_accounting.service.LawDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lawDetails")
public class LawDetailsController {

    private final LawDetailsService service;

    private final LawDetailsMapper mapper;

    public LawDetailsController(LawDetailsService service, LawDetailsMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Operation(summary = "Get all existing Law Details")
    @GetMapping("/")
    public ResponseEntity<List<LawDetailsDTO>> getLawDetails() {
        List<LawDetailsDTO> dtos = service.findAll()
                .stream().map(mapper::toDto).toList();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @Operation(summary = "Add new Law Details")
    @PostMapping("/save")
    public ResponseEntity<LawDetailsDTO> saveLawDetails(@RequestBody LawDetailsDTO dto) {
        LawDetails lawDetails = service.save(mapper.toEntity(dto));
        return new ResponseEntity<>(mapper.toDto(lawDetails), HttpStatus.OK);
    }

    @Operation(summary = "Delete Law Details")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLawDetails(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>("Law Details deleted", HttpStatus.OK);
    }

    @Operation(summary = "Get Law Details by id")
    @GetMapping("/getById/{id}")
    public ResponseEntity<LawDetailsDTO> getById(@Parameter(description = "id of Law Details") @PathVariable Long id) {
        LawDetailsDTO dto = mapper.toDto(service.getById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Edit Law Details")
    @PutMapping("/edit/{id}")
    public ResponseEntity<LawDetailsDTO> editLawDetails(@PathVariable Long id, @RequestBody LawDetailsDTO dto) {
        dto.setId(id);
        LawDetails lawDetails = service.update(mapper.toEntity(dto));
        return new ResponseEntity<>(mapper.toDto(lawDetails), HttpStatus.OK);
    }

}
