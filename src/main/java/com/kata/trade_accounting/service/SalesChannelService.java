package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.SalesChannelDTO;

import java.util.List;

public interface SalesChannelService {

    List<SalesChannelDTO> findAll();

    SalesChannelDTO getById(Long id);

    SalesChannelDTO save(SalesChannelDTO dto);

    void deleteById(Long id);

    SalesChannelDTO edit(Long id, SalesChannelDTO dto);
}
