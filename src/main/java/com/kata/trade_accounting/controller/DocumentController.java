package com.kata.trade_accounting.controller;

import com.kata.trade_accounting.dto.DocumentDTO;
import com.kata.trade_accounting.service.DocumentService;
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
@RequestMapping("/document")
@Tag(name = "Operation with Document", description = "Basic crud operation with Document")
public class DocumentController {

    private final DocumentService service;

    @Operation(summary = "Get all existing Documents")
    @Tag(name = "Operation with Document")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Got information about all existing Documents",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = DocumentDTO.class)))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Document not found", content = @Content)
            })
    @GetMapping("/")
    public ResponseEntity<List<DocumentDTO>> getAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Create new Document")
    @Tag(name = "Operation with Document")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Document created",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = DocumentDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Document not created", content = @Content)
            })
    @PostMapping(value = "/save", consumes = "application/json")
    public ResponseEntity<DocumentDTO> save(
            @Parameter(name = "Document",
                    description = "New Document")
            @RequestBody DocumentDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.OK);
    }

    @Operation(summary = "Delete SDocument")
    @Tag(name = "Operation with Document")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Document deleted",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = DocumentDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Document not found", content = @Content)
            })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(
            @Parameter(in = ParameterIn.PATH, name = "id",
                    required = true, description = "The identifier of Document",
                    allowReserved = true)
            @PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>("Document deleted", HttpStatus.OK);
    }

    @Operation(summary = "Get Document by it id")
    @Tag(name = "Operation with Document")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Information about specific Document",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = DocumentDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Document not found", content = @Content)
            })
    @GetMapping("/getById/{id}")
    public ResponseEntity<DocumentDTO> getById(
            @Parameter(in = ParameterIn.PATH, name = "id",
                    required = true, description = "The identifier of Document",
                    allowReserved = true)
            @PathVariable Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @Operation(summary = "Edit specific Document")
    @Tag(name = "Operation with Document")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Document edited",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = DocumentDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Document not found", content = @Content)
            })
    @PutMapping("/edit/{id}")
    public ResponseEntity<DocumentDTO> edit(
            @Parameter(in = ParameterIn.PATH, name = "id",
                    required = true, description = "The identifier of Document",
                    allowReserved = true)
            @PathVariable Long id,
            @Parameter(name = "Changes in Document", description = "Information which must be edited")
            @RequestBody DocumentDTO dto) {
        return new ResponseEntity<>(service.edit(id, dto), HttpStatus.OK);
    }
}
