package com.kata.trade_accounting.controller;

import com.kata.trade_accounting.dto.WareHouseDTO;
import com.kata.trade_accounting.mapper.WareHouseMapper;
import com.kata.trade_accounting.model.WareHouse;
import com.kata.trade_accounting.service.WareHouseService;
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
public class WareHouseController {
    private final WareHouseService service;
    private final WareHouseMapper mapper;

    public WareHouseController(WareHouseService service, WareHouseMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Operation(summary = "Get all existing WareHouses")
    @GetMapping("/")
    public ResponseEntity<List<WareHouseDTO>> getWareHouses() {
        List<WareHouseDTO> listDTO = service.findAll()
                .stream().map(mapper::toDto).toList();
        return new ResponseEntity<>(listDTO, HttpStatus.OK);
    }

    @Operation(summary = "Add new WareHouse")
    @PostMapping("/save")
    public ResponseEntity<WareHouseDTO> saveWareHouse(@RequestBody WareHouseDTO dto) {
        WareHouse wareHouse = service.save(mapper.toEntity(dto));
        return new ResponseEntity<>(mapper.toDto(wareHouse), HttpStatus.OK);
    }

    @Operation(summary = "Delete WareHouse")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteWareHouse(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>("Law Details deleted", HttpStatus.OK);
    }

    @Operation(summary = "Get WareHouse by id")
    @GetMapping("/getById/{id}")
    public ResponseEntity<WareHouseDTO> getWareHouseById(@Parameter(description = "id of Law Details") @PathVariable Long id) {
        WareHouseDTO dto = mapper.toDto(service.findById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Edit WareHouse")
    @PutMapping("/edit/{id}")
    public ResponseEntity<WareHouseDTO> editWareHouse(@PathVariable Long id, @RequestBody WareHouseDTO dto) {
        dto.setId(id);
        WareHouse wareHouse = service.update(mapper.toEntity(dto));
        return new ResponseEntity<>(mapper.toDto(wareHouse), HttpStatus.OK);
    }
}
