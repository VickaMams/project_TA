package com.kata.trade_accounting.service;

import com.kata.trade_accounting.model.Group;

import java.util.List;

public interface GroupService {
    List<Group> findAll();
    Group getById(Long id);
    Group save(Group group);
    void deleteById(Long id);
    Group update(Group group);
}
