package com.kata.trade_accounting.controller;

import com.kata.trade_accounting.dto.AccountingTypeDTO;
import com.kata.trade_accounting.service.AccountingTypeService;
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
@RequestMapping("/accountingType")
@Tag(name = "Operation with Accounting Type", description = "Basic crud operation with Accounting Type")
public class AccountingTypeController {

    private final AccountingTypeService service;

    @Operation(summary = "Get all existing Accounting Type")
    @Tag(name = "Operation with Accounting Type")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Got information about all existing Accounting Type",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = AccountingTypeDTO.class)))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Accounting Type not found", content = @Content)
            })
    @GetMapping("/")
    public ResponseEntity<List<AccountingTypeDTO>> getAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Create new Accounting Type")
    @Tag(name = "Operation with Accounting Type")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Accounting Type created",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = AccountingTypeDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Accounting Type not created", content = @Content)
            })
    @PostMapping(value = "/save", consumes = "application/json")
    public ResponseEntity<AccountingTypeDTO> save(
            @Parameter(name = "Accounting Type",
                    description = "New Accounting Type")
            @RequestBody AccountingTypeDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.OK);
    }

    @Operation(summary = "Delete Accounting Type")
    @Tag(name = "Operation with Accounting Type")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Accounting Type deleted",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = AccountingTypeDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Accounting Type not found", content = @Content)
            })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(
            @Parameter(in = ParameterIn.PATH, name = "id",
                    required = true, description = "The identifier of Accounting Type",
                    allowReserved = true)
            @PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>("Accounting Type deleted", HttpStatus.OK);
    }

    @Operation(summary = "Get Accounting Type by it id")
    @Tag(name = "Operation with Accounting Type")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Information about specific Accounting Type",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = AccountingTypeDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Accounting Type not found", content = @Content)
            })
    @GetMapping("/getById/{id}")
    public ResponseEntity<AccountingTypeDTO> getById(
            @Parameter(in = ParameterIn.PATH, name = "id",
                    required = true, description = "The identifier of Accounting Type",
                    allowReserved = true)
            @PathVariable Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @Operation(summary = "Get Accounting Type by product id")
    @Tag(name = "Operation with Accounting Type")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Information about specific Accounting Type",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = AccountingTypeDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Accounting Type not found", content = @Content)
            })
    @GetMapping("/getByProductId/{id}")
    public ResponseEntity<AccountingTypeDTO> getByProductId(
            @Parameter(in = ParameterIn.PATH, name = "id",
                    required = true, description = "The identifier of Product",
                    allowReserved = true)
            @PathVariable Long id) {
        return new ResponseEntity<>(service.getByProductId(id), HttpStatus.OK);
    }

    @Operation(summary = "Edit specific Accounting Type")
    @Tag(name = "Operation with Accounting Type")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Accounting Type edited",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = AccountingTypeDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Accounting Type not found", content = @Content)
            })
    @PutMapping("/edit/{id}")
    public ResponseEntity<AccountingTypeDTO> edit(
            @Parameter(in = ParameterIn.PATH, name = "id",
                    required = true, description = "The identifier of Accounting Type",
                    allowReserved = true)
            @PathVariable Long id,
            @Parameter(name = "Changes in Accounting Type", description = "Information which must be edited")
            @RequestBody AccountingTypeDTO dto) {
        return new ResponseEntity<>(service.edit(id, dto), HttpStatus.OK);
    }
}
