package com.kata.trade_accounting.controller;


import com.kata.trade_accounting.dto.LegalEntityRresponseDto;
import com.kata.trade_accounting.dto.LegalEntityRequestDto;
import com.kata.trade_accounting.model.LegalEntity;
import com.kata.trade_accounting.service.LegalEntityService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/legalEntity")
@Api(tags = "Юридичесике лица")
public class LegalEntityRestController {
    private final LegalEntityService legalEntityService;

    public LegalEntityRestController(LegalEntityService legalEntityService) {
        this.legalEntityService = legalEntityService;
    }


    @GetMapping()
    @ApiOperation(value = "Получение всех юридических лиц", response = LegalEntity.class, responseContainer = "list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное всех юридических лиц"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для просмотра контента"),
            @ApiResponse(code = 404, message = "Невозможно найти.")
    })
    public ResponseEntity<List<LegalEntityRresponseDto>> getLegalEntityDto() {
        return new ResponseEntity<>(legalEntityService.findAll(), HttpStatus.OK);
    }


    @PostMapping
    @ApiOperation(value = "Добавление нового юридическго лица", response = LegalEntityRresponseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное добавление нового юридическго лица"),
            @ApiResponse(code = 201, message = "Успешное добавление нового юридическго лица"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для создания ставки НДС"),
            @ApiResponse(code = 404, message = "Невозможно найти")
    })
    public ResponseEntity<Void> createLegalEntity(@RequestBody LegalEntityRequestDto legalEntityRequestDto) {
        legalEntityService.addLegalEntity(legalEntityRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Обновление юридическго лица")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление юридическго лица"),
            @ApiResponse(code = 201, message = "Успешное обновление юридическго лица"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для обновления юридическго лица"),
            @ApiResponse(code = 404, message = "Невозможно найти")
    })
    public ResponseEntity<Void> putLegalEntity(@RequestBody LegalEntityRequestDto legalEntityRequestDto) {
        legalEntityService.addLegalEntity(legalEntityRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаление юридическго лица")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Юридическое лицо успешно удалено"),
            @ApiResponse(code = 400, message = "По переданному id,  Юридическое лицо не найдено"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для удаления юридическго лица"),
            @ApiResponse(code = 404, message = "Невозможно найти")
    })
    public ResponseEntity<Void> deleteLegalEntityById(
            @ApiParam(value = "юридическго лица") @PathVariable Long id) {
        legalEntityService.removeLegalEntityById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
