package com.kata.trade_accounting.service;

import com.kata.trade_accounting.model.LawDetails;

import java.util.List;

public interface LawDetailsService {
    List<LawDetails> findAll();

    LawDetails getById(Long id);

    LawDetails save(LawDetails lawDetails);

    void deleteById(Long id);

    LawDetails update(LawDetails lawDetails);
}
