package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.LawDetailsDTO;

import java.util.List;

public interface LawDetailsService {
    List<LawDetailsDTO> findAll();

    LawDetailsDTO getById(Long id);

    LawDetailsDTO save(LawDetailsDTO dto);

    void deleteById(Long id);

    LawDetailsDTO edit(Long id, LawDetailsDTO dto);
}
