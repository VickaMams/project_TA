package com.kata.trade_accounting.controller;


import com.kata.trade_accounting.dto.ProductDTO;
import com.kata.trade_accounting.mapper.ProductMapper;
import com.kata.trade_accounting.service.ProductService;
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
@RequestMapping("/product")
@AllArgsConstructor
@Tag(name = "Product controller", description = "Product controller work ")
public class ProductController {


    private final ProductService service;

    private final ProductMapper mapper;

    @Tag(name = "Product controller")
    @Operation(summary = "Get all existing Product")
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Got information about all existing Product",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProductDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<ProductDTO>> getProduct() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Tag(name = "Product controller")
    @Operation(summary = "Create new Product")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Product created",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = ProductDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Product not created", content = @Content)
            })
    @PostMapping("/save")
    public ResponseEntity<ProductDTO> saveProduct(
            @Parameter(description = "New Product")
            @RequestBody ProductDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.OK);
    }

    @Tag(name = "Product controller")
    @Operation(summary = "Delete Product")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Product deleted",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = ProductDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)
            })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(
            @Parameter(description = "Product id")
            @PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>("Product was deleted", HttpStatus.OK);
    }

    @Tag(name = "Product controller")
    @Operation(summary = "Get products by it id")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Information about specific Product",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = ProductDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)
            })
    @GetMapping("/getById/{id}")
    public ResponseEntity<ProductDTO> getById(
            @Parameter(description = "Product id")
            @PathVariable Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @Tag(name = "Product controller")
    @Operation(summary = "Edit specific Product")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Law Details edited",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = ProductDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)
            })
    @PutMapping("/edit/{id}")
    public ResponseEntity<ProductDTO> editProduct(
            @Parameter(description = "Product id")
            @PathVariable Long id,
            @Parameter(description = "Information which must be updated")
            @RequestBody ProductDTO dto) {
        return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
    }
}
