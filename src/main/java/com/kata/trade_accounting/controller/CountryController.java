package com.kata.trade_accounting.controller;

import com.kata.trade_accounting.dto.CountryDTO;
import com.kata.trade_accounting.model.Country;
import com.kata.trade_accounting.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/api/countries")
@Tag(name = "Country", description = "The Country API")
@AllArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @Operation(summary = "Gets all countries")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            description = "The countries found",
            content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CountryDTO.class))
                    )
            }),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Countries not found", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<CountryDTO>> getAllCountries() {
        return new ResponseEntity<>(countryService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Gets country by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Country information",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = CountryDTO.class))
                            )
                    }),
            @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
            @ApiResponse(responseCode = "404", description = "Country not found", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> getCountry(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(countryService.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Add new country")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "The country has been created",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = CountryDTO.class))
                            )
                    }),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Country not created", content = @Content)
    })
    @PostMapping
    public ResponseEntity<CountryDTO> addNewCountry(@RequestBody Country country) {
        countryService.save(country);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Delete country")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "The country has been deleted",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = CountryDTO.class))
                            )
                    }),
            @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
            @ApiResponse(responseCode = "404", description = "Country not deleted", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        countryService.deleteById(id);
        return new ResponseEntity<>("Country deleted",HttpStatus.OK);
    }

    @Operation(summary = "Edit country")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "The country was updated",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = CountryDTO.class))
                            )
                    }),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Country wasn't updated", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<CountryDTO> update(@RequestBody CountryDTO countryDTO, @PathVariable("id") Long id) {
        return new ResponseEntity<>(countryService.update(countryDTO, id), HttpStatus.OK);
    }
}
