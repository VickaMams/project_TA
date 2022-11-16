package com.kata.trade_accounting.controller;

import com.kata.trade_accounting.dto.LawDetailsDTO;
import com.kata.trade_accounting.mapper.LawDetailsMapper;
import com.kata.trade_accounting.model.LawDetails;
import com.kata.trade_accounting.service.LawDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Got information about all existing Law Details",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = LawDetailsDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Law Details not found", content = @Content)
            })
    @GetMapping("/")
    public ResponseEntity<List<LawDetailsDTO>> getAllLawDetails() {
        List<LawDetailsDTO> dtos = service.findAll()
                .stream().map(mapper::toDto).toList();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @Operation(summary = "Create new Law Details")
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
    @PostMapping("/save")
    public ResponseEntity<LawDetailsDTO> saveLawDetails(@Parameter(description = "New Law Details") @RequestBody LawDetailsDTO dto) {
        LawDetails lawDetails = service.save(mapper.toEntity(dto));
        return new ResponseEntity<>(mapper.toDto(lawDetails), HttpStatus.OK);
    }

    @Operation(summary = "Delete Law Details")
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
    public ResponseEntity<String> deleteLawDetails(@Parameter(description = "Law Details id") @PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>("Law Details deleted", HttpStatus.OK);
    }

    @Operation(summary = "Get Law Details by it id")
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
    public ResponseEntity<LawDetailsDTO> getById(@Parameter(description = "Law Details id") @PathVariable Long id) {
        LawDetailsDTO dto = mapper.toDto(service.getById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Edit specific Law Details")
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
    public ResponseEntity<LawDetailsDTO> editLawDetails(@Parameter(description = "Law Details id") @PathVariable Long id, @Parameter(description = "Information which must be updated") @RequestBody LawDetailsDTO dto) {
        dto.setId(id);
        LawDetails lawDetails = service.update(mapper.toEntity(dto));
        return new ResponseEntity<>(mapper.toDto(lawDetails), HttpStatus.OK);
    }

}
