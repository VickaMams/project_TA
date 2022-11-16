package com.kata.trade_accounting.service;

import com.kata.trade_accounting.model.Group;
import com.kata.trade_accounting.repository.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    private final GroupRepository repository;

    @Override
    public List<Group> findAll() {
        return repository.findAll();
    }

    @Override
    public Group getById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Group save(Group group) {
        return repository.save(group);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Group update(Group group) {
        return repository.save(group);
    }
}
