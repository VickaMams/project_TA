package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.NdsDto;
import com.kata.trade_accounting.exception.NotFoundByIdException;
import com.kata.trade_accounting.controller.mapper.NdsMapper;
import com.kata.trade_accounting.repository.NdsDao;
import com.kata.trade_accounting.model.Nds;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class NdsServiceImpl implements NdsService {
    private final NdsDao ndsDao;
    private final NdsMapper ndsMapper;

    public NdsServiceImpl(NdsDao ndsDao, NdsMapper ndsMapper) {
        this.ndsDao = ndsDao;
        this.ndsMapper = ndsMapper;
    }


    @Override
    public List<Nds> findAll() {
        return ndsDao.findAll();
    }

    @Override
    public void saveNds(NdsDto ndsDto) {
        ndsDao.save(ndsMapper.toNds(ndsDto));
    }

    @Override
    public void deleteNdsById(Long id) {
        Nds nds = findById(id);
        if (nds != null) {
            nds.setRemoved(true);
        } else {
            throw new NotFoundByIdException("Ставка не найдена");
        }
    }

    @Override
    public Nds findById(Long id) {
        return ndsDao.findById(id).orElse(null);
    }
}
