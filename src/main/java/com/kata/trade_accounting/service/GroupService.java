package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.GroupDTO;

import java.util.List;

public interface GroupService {
    List<GroupDTO> findAll();
    GroupDTO getById(Long id);
    GroupDTO save(GroupDTO groupDTO);
    void deleteById(Long id);
    GroupDTO update(GroupDTO groupDTO);
}
