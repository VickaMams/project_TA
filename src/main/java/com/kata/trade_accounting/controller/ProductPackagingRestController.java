package com.kata.trade_accounting.controller;


import com.kata.trade_accounting.dto.ProductPackagingDto;
import com.kata.trade_accounting.service.ProductPackagingService;
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
@RequestMapping("/api/productPackaging")
@Api(tags = "Фасовка товара")
public class ProductPackagingRestController {

    private final ProductPackagingService productPackagingService;

    public ProductPackagingRestController(ProductPackagingService productPackagingService) {
        this.productPackagingService = productPackagingService;
    }

    @GetMapping()
    @ApiOperation(value = "Получение всех видов фасовок товара", response = ProductPackagingDto.class, responseContainer = "list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное всех всех видов фасовок товара"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для просмотра контента"),
            @ApiResponse(code = 404, message = "Невозможно найти.")
    })
    public ResponseEntity<List<ProductPackagingDto>> getProductPackagingDto() {
        return new ResponseEntity<>(productPackagingService.findAll(), HttpStatus.OK);
    }


    @PostMapping
    @ApiOperation(value = "Добавление нового вида фасовки товара", response = ProductPackagingDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное добавление нового вида фасовки товара"),
            @ApiResponse(code = 201, message = "Успешное добавление нового вида фасовки товара"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для создания нового вида фасовки товара"),
            @ApiResponse(code = 404, message = "Невозможно найти")
    })
    public ResponseEntity<Void> createProductPackaging(@RequestBody ProductPackagingDto productPackagingDto) {
        productPackagingService.addProductPackaging(productPackagingDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Обновление вида фасовки товара")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление вида фасовки товара"),
            @ApiResponse(code = 201, message = "Успешное обновление вида фасовки товара"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для обновления вида фасовки товара"),
            @ApiResponse(code = 404, message = "Невозможно найти")
    })
    public ResponseEntity<Void> putProductPackaging(@RequestBody ProductPackagingDto productPackagingDto) {
        productPackagingService.addProductPackaging(productPackagingDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаление вида фасовки товара")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Фасовка товара успешно удалено"),
            @ApiResponse(code = 400, message = "По переданному id,  фасовка не найдена"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для удаления фасовки товара"),
            @ApiResponse(code = 404, message = "Невозможно найти")
    })
    public ResponseEntity<Void> deleteProductPackagingById(
            @ApiParam(value = "id  фасовки товара") @PathVariable Long id) {
        productPackagingService.removeProductPackaging(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
