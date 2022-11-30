package com.kata.trade_accounting.controller;

import com.kata.trade_accounting.dto.SalesChannelDTO;
import com.kata.trade_accounting.service.SalesChannelService;
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
@RequestMapping("/salesChannel")
@Tag(name = "Operation with Sales Channel", description = "Basic crud operation with Sales Channel")
public class SalesChannelController {

    private final SalesChannelService service;

    @Operation(summary = "Get all existing Sales Channel")
    @Tag(name = "Operation with Sales Channel")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Got information about all existing Sales Channel",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = SalesChannelDTO.class)))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Sales Channel not found", content = @Content)
            })
    @GetMapping("/")
    public ResponseEntity<List<SalesChannelDTO>> getAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Create new Sales Channel")
    @Tag(name = "Operation with Sales Channel")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Sales Channel created",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = SalesChannelDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Sales Channel not created", content = @Content)
            })
    @PostMapping(value = "/save", consumes = "application/json")
    public ResponseEntity<SalesChannelDTO> save(
            @Parameter(name = "Sales Channel",
                    description = "New Sales Channel")
            @RequestBody SalesChannelDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.OK);
    }

    @Operation(summary = "Delete Sales Channel")
    @Tag(name = "Operation with Sales Channel")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Sales Channel deleted",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = SalesChannelDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Sales Channel not found", content = @Content)
            })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(
            @Parameter(in = ParameterIn.PATH, name = "id",
                    required = true, description = "The identifier of Sales Channel",
                    allowReserved = true)
            @PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>("Sales Channel deleted", HttpStatus.OK);
    }

    @Operation(summary = "Get Sales Channel by it id")
    @Tag(name = "Operation with Sales Channel")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Information about specific Sales Channel",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = SalesChannelDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Sales Channel not found", content = @Content)
            })
    @GetMapping("/getById/{id}")
    public ResponseEntity<SalesChannelDTO> getById(
            @Parameter(in = ParameterIn.PATH, name = "id",
                    required = true, description = "The identifier of Sales Channel",
                    allowReserved = true)
            @PathVariable Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @Operation(summary = "Edit specific Sales Channel")
    @Tag(name = "Operation with Sales Channel")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Sales Channel edited",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = SalesChannelDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Sales Channel not found", content = @Content)
            })
    @PutMapping("/edit/{id}")
    public ResponseEntity<SalesChannelDTO> edit(
            @Parameter(in = ParameterIn.PATH, name = "id",
                    required = true, description = "The identifier of Sales Channel",
                    allowReserved = true)
            @PathVariable Long id,
            @Parameter(name = "Changes in Sales Channel", description = "Information which must be edited")
            @RequestBody SalesChannelDTO dto) {
        return new ResponseEntity<>(service.edit(id, dto), HttpStatus.OK);
    }
}
