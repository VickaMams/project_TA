package com.kata.trade_accounting.controller;

import com.kata.trade_accounting.dto.CurrencyDTO;
import com.kata.trade_accounting.service.CurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
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

@AllArgsConstructor
@RestController
@RequestMapping("/currency")
@Tag(name = "Operation with Currency", description = "Basic crud operation with Currency")
public class CurrencyController {

    private final CurrencyService service;

    @Operation(summary = "Get all existing Currencies")
    @Tag(name = "Operation with Currency")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Got information about all existing Currencies",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = CurrencyDTO.class)))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Currencies not found", content = @Content)
            })
    @GetMapping("/")
    public ResponseEntity<List<CurrencyDTO>> getAllCurrencies() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Create new Currency")
    @Tag(name = "Operation with Currency")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Currency created",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = CurrencyDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Currency not created", content = @Content)
            })
    @PostMapping(value = "/save", consumes = "application/json")
    public ResponseEntity<CurrencyDTO> saveCurrency(
            @Parameter(name = "Currency",
                    description = "New Currency")
            @RequestBody CurrencyDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.OK);
    }

    @Operation(summary = "Delete Currency")
    @Tag(name = "Operation with Currency")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Currency deleted",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = CurrencyDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Currency not found", content = @Content)
            })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(
            @Parameter(in = ParameterIn.PATH, name = "id",
                    required = true, description = "The identifier of Currency",
                    allowReserved = true)
            @PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>("Currency deleted", HttpStatus.OK);
    }

    @Operation(summary = "Get Currency by it id")
    @Tag(name = "Operation with Currency")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Information about specific Currency",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = CurrencyDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Currency not found", content = @Content)
            })
    @GetMapping("/getById/{id}")
    public ResponseEntity<CurrencyDTO> getById(
            @Parameter(in = ParameterIn.PATH, name = "id",
                    required = true, description = "The identifier of Currency",
                    allowReserved = true)
            @PathVariable Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @Operation(summary = "Edit specific Currency")
    @Tag(name = "Operation with Currency")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Currency edited",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = CurrencyDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Currency not found", content = @Content)
            })
    @PutMapping("/edit/{id}")
    public ResponseEntity<CurrencyDTO> editCurrency(
            @Parameter(in = ParameterIn.PATH, name = "id",
                    required = true, description = "The identifier of Currency",
                    allowReserved = true)
            @PathVariable Long id,
            @Parameter(name = "Changes in Currency", description = "Information which must be edited")
            @RequestBody CurrencyDTO dto) {
        return new ResponseEntity<>(service.edit(id, dto), HttpStatus.OK);
    }

}
