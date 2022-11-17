package com.kata.trade_accounting.service;


import com.kata.trade_accounting.model.Nds;

import java.util.List;

public interface NdsService {
    List<Nds> findAll();

    void createNds(Nds nds);

    void deleteNdsById(Long id);

    void updateNdsById(Long id);

    boolean isExistById(Long id);

}
