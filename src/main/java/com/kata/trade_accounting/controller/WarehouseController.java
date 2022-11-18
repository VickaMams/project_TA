package com.kata.trade_accounting.controller;

import com.kata.trade_accounting.dto.WarehouseDTO;
import com.kata.trade_accounting.service.WarehouseDTOService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Tag(name = "Warehouse-Controller", description = "The controller is used to work with the warehouse.")
public class WarehouseController {
    private final WarehouseDTOService service;

    @Operation(summary = "Get all existing warehouses")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Get information about all existing warehouses",
                            content = {
                                    @Content(mediaType = "application/json", array = @ArraySchema(
                                            schema = @Schema(implementation = WarehouseDTO.class)))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Warehouses not found", content = @Content)
            })
    @GetMapping("/")
    public ResponseEntity<List<WarehouseDTO>> getWareHouses() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Get warehouse by id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Warehouse information",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = WarehouseDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Warehouse not found", content = @Content)
            })
    @GetMapping("/getById/{id}")
    public ResponseEntity<WarehouseDTO> getWarehouseById(
            @PathVariable @Parameter(description = "id of warehouse") Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Add new warehouse")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "the warehouse has been created",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = WarehouseDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Warehouse not created", content = @Content)
            })
    @PostMapping("/save")
    public ResponseEntity<WarehouseDTO> saveWarehouse(
            @RequestBody @Parameter(description = "Warehouse retention DTO") WarehouseDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.OK);
    }

    @Operation(summary = "Delete warehouse")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Warehouse deleted"),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Warehouse not deleted", content = @Content)
            })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteWarehouse(
            @PathVariable @Parameter(description = "id of warehouse") Long id) {
        service.deleteById(id);
        return new ResponseEntity<>("Warehouse deleted", HttpStatus.OK);
    }


    @Operation(summary = "Edit warehouse")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "The warehouse changed",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = WarehouseDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Warehouse not changed", content = @Content)
            })
    @PutMapping("/edit/{id}")
    public ResponseEntity<WarehouseDTO> editWarehouse(
            @RequestBody @Parameter(description = "warehouse retention DTO") WarehouseDTO dto) {
        return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
    }
}
