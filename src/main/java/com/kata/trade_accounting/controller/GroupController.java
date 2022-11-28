package com.kata.trade_accounting.controller;


import com.kata.trade_accounting.dto.GroupDTO;
import com.kata.trade_accounting.mapper.GroupMapper;
import com.kata.trade_accounting.service.GroupService;
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
@RequestMapping("/group")
@AllArgsConstructor
@Tag(name = "Group controller", description = "Group controller work ")
public class GroupController {


    private final GroupService service;

    private final GroupMapper mapper;

    @Tag(name = "Group controller")
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
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Tag(name = "Group controller")
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
        return new ResponseEntity<>(service.save(dto), HttpStatus.OK);
    }

    @Tag(name = "Group controller")
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
        return new ResponseEntity<>("Group was deleted", HttpStatus.OK);
    }

    @Tag(name = "Group controller")
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
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @Tag(name = "Group controller")
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
        return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
    }
}
