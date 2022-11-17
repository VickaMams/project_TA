package com.kata.trade_accounting.service;

import com.kata.trade_accounting.repository.NdsDao;
import com.kata.trade_accounting.model.Nds;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class NdsServiceImpl implements NdsService {
    private final NdsDao ndsDao;

    public NdsServiceImpl(NdsDao ndsDao) {
        this.ndsDao = ndsDao;
    }


    @Override
    public List<Nds> findAll() {
        return ndsDao.findAll();
    }

    @Override
    public void createNds(Nds nds) {
        ndsDao.save(nds);
    }

    @Override
    public void deleteNdsById(Long id) {
        ndsDao.deleteById(id);
    }

    @Override
    public void updateNdsById(Long id) {

    }

    @Override
    public boolean isExistById(Long id) {
        return true;
    }

    ;
}
