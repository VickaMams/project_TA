package com.kata.trade_accounting.service;


import com.kata.trade_accounting.dto.NdsDto;
import com.kata.trade_accounting.model.Nds;

import java.util.List;


public interface NdsService {
    List<Nds> findAll();

    void saveNds(NdsDto ndsDto);

    void deleteNdsById(Long id);

    Nds findById(Long id);

}
