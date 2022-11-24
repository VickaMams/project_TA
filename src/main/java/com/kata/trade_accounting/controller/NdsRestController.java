package com.kata.trade_accounting.controller;

import com.kata.trade_accounting.dto.NdsDto;
import com.kata.trade_accounting.controller.mapper.NdsDtoMapper;
import com.kata.trade_accounting.service.NdsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Validated
@RestController
@RequestMapping("/api/nds")
@Api(tags = "НДС")
public class NdsRestController {

    private final NdsService ndsService;
    private final NdsDtoMapper ndsDtoMapper;

    public NdsRestController(NdsService ndsService, NdsDtoMapper ndsDtoMapper) {
        this.ndsService = ndsService;
        this.ndsDtoMapper = ndsDtoMapper;

    }

    @GetMapping()
    @ApiOperation(value = "Получение списка значений НДС", response = NdsDto.class, responseContainer = "list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка НДС"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для просмотра контента"),
            @ApiResponse(code = 404, message = "Невозможно найти.")
    })
    public ResponseEntity<List<NdsDto>> getNds() {
        List<NdsDto> ndsDto = ndsService.findAll()
                .stream().map(ndsDtoMapper::toNdsDto)
                .toList();
        return new ResponseEntity<>(ndsDto, HttpStatus.OK);

    }

    @PostMapping
    @ApiOperation(value = "Создание новой ставки НДС", response = NdsDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное добавление новой ставки НДС"),
            @ApiResponse(code = 201, message = "Успешное добавление новой ставки НДС"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для создания ставки НДС"),
            @ApiResponse(code = 404, message = "Невозможно найти")
    })
    public ResponseEntity<Void> createNds(@RequestBody NdsDto ndsDto) {
        ndsService.saveNds(ndsDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаление ставки НДС")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ставка НДС успешно удалена"),
            @ApiResponse(code = 400, message = "По переданному id,  ставка НДС не найдена"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для удаления ставки НДС"),
            @ApiResponse(code = 404, message = "Невозможно найти")
    })
    public ResponseEntity<Void> deleteNdsById(
            @ApiParam(value = "id ставки НДС") @PathVariable Long id) {
        ndsService.deleteNdsById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Обновление ставки НДС ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление ставки НДС"),
            @ApiResponse(code = 201, message = "Успешное обновление ставки НДС"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для обновления ставки НДС"),
            @ApiResponse(code = 404, message = "Невозможно найти")
    })
    public ResponseEntity<Void> putNds(@RequestBody NdsDto ndsDto) {
        ndsService.saveNds(ndsDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
