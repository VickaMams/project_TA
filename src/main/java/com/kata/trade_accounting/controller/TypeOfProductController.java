package com.kata.trade_accounting.controller;


import com.kata.trade_accounting.dto.TypeOfProductDto;
import com.kata.trade_accounting.service.TypeOfProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@RequestMapping("/api/typeOfProduct")
@Api(tags = "Тип продукции")
public class TypeOfProductController {
    private final TypeOfProductService typeOfProductService;

    public TypeOfProductController(TypeOfProductService typeOfProductService) {
        this.typeOfProductService = typeOfProductService;
    }

    @GetMapping()
    @ApiOperation(value = "Получение всех типов продукции", response = TypeOfProductDto.class, responseContainer = "list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное всех типов продукции"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для просмотра контента"),
            @ApiResponse(code = 404, message = "Невозможно найти.")
    })

    public ResponseEntity<List<TypeOfProductDto>> getLegalEntityDto() {
        return new ResponseEntity<>(typeOfProductService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Добавление нового типа продукции", response = TypeOfProductDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное добавление нового типа продукции"),
            @ApiResponse(code = 201, message = "Успешное добавление нового типа продукции"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для создания типа продукции"),
            @ApiResponse(code = 404, message = "Невозможно найти")
    })
    public ResponseEntity<Void> createLegalEntity(@RequestBody TypeOfProductDto typeOfProductDto) {
        typeOfProductService.addTypeOfProduct(typeOfProductDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Обновление типа продукции")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление типа продукции"),
            @ApiResponse(code = 201, message = "Успешное обновление типа продукции"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для обновления типа продукции"),
            @ApiResponse(code = 404, message = "Невозможно найти")
    })
    public ResponseEntity<Void> putLegalEntity(@RequestBody TypeOfProductDto typeOfProductDto) {
        typeOfProductService.addTypeOfProduct(typeOfProductDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаление типа продукции")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Тип продукции успешно удален"),
            @ApiResponse(code = 400, message = "По переданному id,  тип продукции не найден"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для удаления типа продукции"),
            @ApiResponse(code = 404, message = "Невозможно найти")
    })
    public ResponseEntity<Void> deleteTypeOfProductById(
            @ApiParam(value = "id типа продукции") @PathVariable Long id) {
        typeOfProductService.removeTypeOfProductById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
