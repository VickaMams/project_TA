package com.kata.trade_accounting.controller;

import com.kata.trade_accounting.dto.BasketDTO;
import com.kata.trade_accounting.service.BasketService;
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
@RequestMapping("/baskets")
@AllArgsConstructor
@Tag(name = "Basket-Controller", description = "The controller is used to work with the Basket.")
public class BasketController {
    private final BasketService service;

    @Operation(summary = "Get all existing Basket")
    @Tag(name = "Basket-Controller")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Get information about all existing Basket",
                            content = {
                                    @Content(mediaType = "application/json", array = @ArraySchema(
                                            schema = @Schema(implementation = BasketDTO.class)))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Basket not found", content = @Content)
            })
    @GetMapping("/")
    public ResponseEntity<List<BasketDTO>> getAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Get Basket by id")
    @Tag(name = "Basket-Controller")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Basket information",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = BasketDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Basket not found", content = @Content)
            })
    @GetMapping("/getById/{id}")
    public ResponseEntity<BasketDTO> getById(
            @PathVariable @Parameter(description = "id of Basket") Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Add new Basket")
    @Tag(name = "Basket-Controller")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "the Basket has been created",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = BasketDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Basket not created", content = @Content)
            })
    @PostMapping("/save")
    public ResponseEntity<BasketDTO> save(
            @RequestBody @Parameter(description = "Basket retention DTO") BasketDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.OK);
    }

    @Operation(summary = "Delete Basket")
    @Tag(name = "Basket-Controller")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Basket deleted"),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Basket not deleted", content = @Content)
            })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(
            @PathVariable @Parameter(description = "id of Basket") Long id) {
        service.deleteById(id);
        return new ResponseEntity<>("Basket deleted", HttpStatus.OK);
    }


    @Operation(summary = "Edit Basket")
    @Tag(name = "Basket-Controller")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "The Basket changed",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = BasketDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Basket not changed", content = @Content)
            })
    @PutMapping("/edit/{id}")
    public ResponseEntity<BasketDTO> edit(
            @RequestBody @Parameter(description = "Basket retention DTO") BasketDTO dto) {
        return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
    }
}
