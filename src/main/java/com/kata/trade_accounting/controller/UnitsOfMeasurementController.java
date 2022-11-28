package com.kata.trade_accounting.controller;

import com.kata.trade_accounting.dto.UnitsOfMeasurementDTO;
import com.kata.trade_accounting.service.UnitsOfMeasurementDTOService;
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
@RequestMapping("/unitsOfMeasurements")
@AllArgsConstructor
@Tag(name = "Units-Of-Measurement-Controller", description = "The controller is used to work with the UnitsOfMeasurement.")
public class UnitsOfMeasurementController {
    private final UnitsOfMeasurementDTOService service;

    @Operation(summary = "Get all existing UnitsOfMeasurement")
    @Tag(name = "Units-Of-Measurement-Controller")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Get information about all existing UnitsOfMeasurement",
                            content = {
                                    @Content(mediaType = "application/json", array = @ArraySchema(
                                            schema = @Schema(implementation = UnitsOfMeasurementDTO.class)))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "UnitsOfMeasurement not found", content = @Content)
            })
    @GetMapping("/")
    public ResponseEntity<List<UnitsOfMeasurementDTO>> getWareHouses() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Get UnitsOfMeasurement by id")
    @Tag(name = "Units-Of-Measurement-Controller")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "UnitsOfMeasurement information",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = UnitsOfMeasurementDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "UnitsOfMeasurement not found", content = @Content)
            })
    @GetMapping("/getById/{id}")
    public ResponseEntity<UnitsOfMeasurementDTO> getWarehouseById(
            @PathVariable @Parameter(description = "id of UnitsOfMeasurement") Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Add new UnitsOfMeasurement")
    @Tag(name = "Units-Of-Measurement-Controller")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "the UnitsOfMeasurement has been created",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = UnitsOfMeasurementDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "UnitsOfMeasurement not created", content = @Content)
            })
    @PostMapping("/save")
    public ResponseEntity<UnitsOfMeasurementDTO> saveWarehouse(
            @RequestBody @Parameter(description = "UnitsOfMeasurement retention DTO") UnitsOfMeasurementDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.OK);
    }

    @Operation(summary = "Delete UnitsOfMeasurement")
    @Tag(name = "Units-Of-Measurement-Controller")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "UnitsOfMeasurement deleted"),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "UnitsOfMeasurement not deleted", content = @Content)
            })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteWarehouse(
            @PathVariable @Parameter(description = "id of UnitsOfMeasurement") Long id) {
        service.deleteById(id);
        return new ResponseEntity<>("UnitsOfMeasurement deleted", HttpStatus.OK);
    }


    @Operation(summary = "Edit UnitsOfMeasurement")
    @Tag(name = "Units-Of-Measurement-Controller")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "The UnitsOfMeasurement changed",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = UnitsOfMeasurementDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "UnitsOfMeasurement not changed", content = @Content)
            })
    @PutMapping("/edit/{id}")
    public ResponseEntity<UnitsOfMeasurementDTO> editWarehouse(
            @RequestBody @Parameter(description = "UnitsOfMeasurement retention DTO") UnitsOfMeasurementDTO dto) {
        return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
    }
}
