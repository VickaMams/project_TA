package com.kata.trade_accounting.controller;


import com.kata.trade_accounting.dto.BarcodeDTO;
import com.kata.trade_accounting.mapper.BarcodeMapper;
import com.kata.trade_accounting.service.BarcodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/barcode")
@AllArgsConstructor
@Tag(name = "Barcode controller", description = "Barcode controller work ")
public class BarcodeController {

    private final BarcodeService service;

    private final BarcodeMapper mapper;

    @Tag(name = "Barcode controller")
    @Operation(summary = "Get all existing Barcode")
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Got information about all existing Barcode",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BarcodeDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Barcode not found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<BarcodeDTO>> getBarcode() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Tag(name = "Barcode controller")
    @Operation(summary = "Create new Barcode")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Barcode created",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = BarcodeDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Barcode not created", content = @Content)
            })
    @PostMapping("/save")
    public ResponseEntity<BarcodeDTO> saveBarcode(
            @Parameter(description = "New Barcode")
            @RequestBody BarcodeDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.OK);
    }

    @Tag(name = "Barcode controller")
    @Operation(summary = "Delete Barcode")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Barcode deleted",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = BarcodeDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Barcode not found", content = @Content)
            })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBarcode(
            @Parameter(description = "Barcode id")
            @PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>("Barcode was deleted", HttpStatus.OK);
    }

    @Tag(name = "Barcode controller")
    @Operation(summary = "Get barcodes by it id")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Information about specific barcode",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = BarcodeDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Barcode not found", content = @Content)
            })
    @GetMapping("/getById/{id}")
    public ResponseEntity<BarcodeDTO> getById(
            @Parameter(description = "Barcode id")
            @PathVariable Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @Tag(name = "Barcode controller")
    @Operation(summary = "Edit specific Barcode")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Law Details edited",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = BarcodeDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Barcode not found", content = @Content)
            })
    @PutMapping("/edit/{id}")
    public ResponseEntity<BarcodeDTO> editBarcode(
            @Parameter(description = "Barcode id")
            @PathVariable Long id,
            @Parameter(description = "Information which must be updated")
            @RequestBody BarcodeDTO dto) {
        return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
    }
}