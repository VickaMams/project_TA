package com.kata.trade_accounting.controller;


import com.kata.trade_accounting.dto.GroupDTO;
import com.kata.trade_accounting.mapper.MapperGroup;
import com.kata.trade_accounting.model.Group;
import com.kata.trade_accounting.service.GroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
@RequestMapping("/group")
@AllArgsConstructor
public class GroupController {


    private final GroupService service;

    private final MapperGroup mapper;

    @Operation(summary = "Get all existing Group")
    @ApiResponses(value = {@ApiResponse(
                            responseCode = "200",
                            description = "Got information about all existing Group",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = GroupDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Group not found", content = @Content)
            })
    @GetMapping("/")
    public ResponseEntity<List<GroupDTO>> getGroup() {
        List<GroupDTO> dtos = service.findAll()
                .stream().map(mapper::toDTO).toList();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }


    @Operation(summary = "Create new Group")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Group created",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = GroupDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Group not created", content = @Content)
            })
    @PostMapping("/save")
    public ResponseEntity<GroupDTO> saveGroup(
            @Parameter(description = "New Group")
            @RequestBody GroupDTO dto) {
        Group group = service.save(mapper.toEntity(dto));
        return new ResponseEntity<>(mapper.toDTO(group), HttpStatus.OK);
    }

    @Operation(summary = "Delete Group")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Group deleted",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = GroupDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Group not found", content = @Content)
            })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGroup(
            @Parameter(description = "Group id")
            @PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>("Group deleted", HttpStatus.OK);
    }

    @Operation(summary = "Get groups by it id")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Information about specific Group",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = GroupDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Group not found", content = @Content)
            })
    @GetMapping("/getById/{id}")
    public ResponseEntity<GroupDTO> getById(
            @Parameter(description = "Group id")
            @PathVariable Long id) {
        GroupDTO dto = mapper.toDTO(service.getById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Edit specific Group")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Law Details edited",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = GroupDTO.class))
                            }),
                    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Group not found", content = @Content)
            })
    @PutMapping("/edit/{id}")
    public ResponseEntity<GroupDTO> editGroup(
            @Parameter(description = "Group id")
            @PathVariable Long id,
            @Parameter(description = "Information which must be updated")
            @RequestBody GroupDTO dto) {
        dto.setId(id);
        Group group = service.update(mapper.toEntity(dto));
        return new ResponseEntity<>(mapper.toDTO(group), HttpStatus.OK);
    }
}
