package com.kata.trade_accounting.service;


import com.kata.trade_accounting.model.Nds;

import java.util.List;
import java.util.Optional;

public interface NdsService {
    List<Nds> findAll();

    void createNds(Nds nds);

    void deleteNdsById(Long id);

    void updateNds(Nds nds);

    Nds findById(Long id);

}
