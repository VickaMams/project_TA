package com.kata.trade_accounting.controller;

import com.kata.trade_accounting.dto.WarehouseDTO;
import com.kata.trade_accounting.mapper.WarehouseMapper;
import com.kata.trade_accounting.model.Warehouse;
import com.kata.trade_accounting.service.WarehouseService;
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
@RequestMapping("/warehouses")
public class WareHouseController {
    private final WarehouseService service;
    private final WarehouseMapper mapper;

    public WareHouseController(WarehouseService service, WarehouseMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Operation(summary = "Get all existing Warehouses")
    @GetMapping("/")
    public ResponseEntity<List<WarehouseDTO>> getWareHouses() {
        List<WarehouseDTO> listDTO = service.findAll()
                .stream().map(mapper::toDto).toList();
        return new ResponseEntity<>(listDTO, HttpStatus.OK);
    }

    @Operation(summary = "Add new Warehouse")
    @PostMapping("/save")
    public ResponseEntity<WarehouseDTO> saveWarehouse(@RequestBody WarehouseDTO dto) {
        Warehouse warehouse = service.save(mapper.toEntity(dto));
        return new ResponseEntity<>(mapper.toDto(warehouse), HttpStatus.OK);
    }

    @Operation(summary = "Delete Warehouse")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteWarehouse(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>("Warehouse deleted", HttpStatus.OK);
    }

    @Operation(summary = "Get Warehouse by id")
    @GetMapping("/getById/{id}")
    public ResponseEntity<WarehouseDTO> getWarehouseById(
            @Parameter(description = "id of Warehouse") @PathVariable Long id) {
        WarehouseDTO dto = mapper.toDto(service.findById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Edit Warehouse")
    @PutMapping("/edit/{id}")
    public ResponseEntity<WarehouseDTO> editWarehouse(@PathVariable Long id, @RequestBody WarehouseDTO dto) {
        dto.setId(id);
        Warehouse warehouse = service.update(mapper.toEntity(dto));
        return new ResponseEntity<>(mapper.toDto(warehouse), HttpStatus.OK);
    }
}
