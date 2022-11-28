package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.BasketDTO;
import com.kata.trade_accounting.exception.IdNotFoundException;
import com.kata.trade_accounting.exception.ModelDeletedException;
import com.kata.trade_accounting.mapper.BasketMapper;
import com.kata.trade_accounting.model.Basket;
import com.kata.trade_accounting.repository.BasketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Predicate;

@Service
@AllArgsConstructor
public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;
    private final BasketMapper mapper;

    @Override
    public List<BasketDTO> findAll() {
        return basketRepository.findAll().stream()
                .filter(Predicate.not(Basket::isRemoved)).map(mapper::toDto).toList();
    }

    @Override
    public BasketDTO findById(Long id) throws IdNotFoundException {
        Basket basket = basketRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("No such Basket with ID " + id));
        if (basket.isRemoved()) {
            throw new IdNotFoundException("Basket was deleted" + id);
        }
        return mapper.toDto(basket);
    }

    @Override
    @Transactional
    public BasketDTO save(BasketDTO basketDTO) {
        Basket basket = basketRepository.findById(basketDTO.getId()).orElse(null);
        if (basket != null) {
            if (basket.isRemoved()) {
                throw new ModelDeletedException("the model with this ID" + basketDTO.getId() + " has been deleted");
            } else {
                throw new IdNotFoundException("this ID" + basketDTO.getId() + " is already in use ");
            }
        }
        basketRepository.save(mapper.toEntity(basketDTO));
        return basketDTO;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        int i = basketRepository.setRemovedTrue(id);
        if (i == 0) {
            throw new IdNotFoundException(String.format("Basket with id=%s not found", id));
        }
    }

    @Override
    @Transactional
    public BasketDTO update(BasketDTO basketDTO) {
        Basket basket = basketRepository.findById(basketDTO.getId())
                .orElseThrow(() -> new IdNotFoundException("No such Basket with ID " + basketDTO.getId()));
        if (basket.isRemoved()) {
            throw new IdNotFoundException("Basket was deleted" + basketDTO.getId());
        }
        basketRepository.save(mapper.toEntity(basketDTO));
        return basketDTO;
    }
}
