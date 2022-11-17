package com.kata.trade_accounting.controller;

import com.kata.trade_accounting.dto.LawDetailsDTO;
import com.kata.trade_accounting.mapper.LawDetailsMapper;
import com.kata.trade_accounting.service.LawDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Operation with Law Details", description = "Basic crud operation with Law Details")
public class LawDetailsController {

    private final LawDetailsService service;

    public LawDetailsController(LawDetailsService service, LawDetailsMapper mapper) {
        this.service = service;
    }

    @Operation(summary = "Get all existing Law Details")
    @Tag(name = "Operation with Law Details")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Got information about all existing Law Details",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = LawDetailsDTO.class)))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Law Details not found", content = @Content)
            })
    @GetMapping("/")
    public ResponseEntity<List<LawDetailsDTO>> getAllLawDetails() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Create new Law Details")
    @Tag(name = "Operation with Law Details")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Law Details created",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = LawDetailsDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Law Details not created", content = @Content)
            })
    @PostMapping(value = "/save", consumes = "application/json")
    public ResponseEntity<LawDetailsDTO> saveLawDetails(
            @Parameter(name = "Law Details",
                    description = "New Law Details")
            @RequestBody LawDetailsDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.OK);
    }

    @Operation(summary = "Delete Law Details")
    @Tag(name = "Operation with Law Details")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Law Details deleted",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = LawDetailsDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Law Details not found", content = @Content)
            })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLawDetails(
            @Parameter(in = ParameterIn.PATH, name = "Law details id",
                    required = true, description = "The identifier of Law Details",
                    allowReserved = true)
            @PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>("Law Details deleted", HttpStatus.OK);
    }

    @Operation(summary = "Get Law Details by it id")
    @Tag(name = "Operation with Law Details")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Information about specific Law Details",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = LawDetailsDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Law Details not found", content = @Content)
            })
    @GetMapping("/getById/{id}")
    public ResponseEntity<LawDetailsDTO> getById(
            @Parameter(in = ParameterIn.PATH, name = "Law details id",
                    required = true, description = "The identifier of Law Details",
                    allowReserved = true)
            @PathVariable Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @Operation(summary = "Edit specific Law Details")
    @Tag(name = "Operation with Law Details")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Law Details edited",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = LawDetailsDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Law Details not found", content = @Content)
            })
    @PutMapping("/edit/{id}")
    public ResponseEntity<LawDetailsDTO> editLawDetails(
            @Parameter(in = ParameterIn.PATH, name = "Law details id",
                    required = true, description = "The identifier of Law Details",
                    allowReserved = true) @PathVariable Long id,
            @Parameter(name = "Changes in Law Details", description = "Information which must be edited")
            @RequestBody LawDetailsDTO dto) {
        return new ResponseEntity<>(service.edit(id, dto), HttpStatus.OK);
    }

}
