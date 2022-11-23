package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.GroupDTO;
import com.kata.trade_accounting.exception.GroupNotFoundException;
import com.kata.trade_accounting.exception.IdNotFoundException;
import com.kata.trade_accounting.mapper.MapperGroup;
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
    private final MapperGroup mapper;

    @Override
    public List<GroupDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    public GroupDTO getById(Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new GroupNotFoundException(String.format("Group with id=%s not found", id))));
    }

    @Override
    public GroupDTO save(GroupDTO groupDTO) {
        repository.save(mapper.toEntity(groupDTO));
        return groupDTO;
    }

    @Override
    public void deleteById(Long id) {
        int i = repository.setRemovedTrue(id);
        if (i == 0) {
            throw new GroupNotFoundException(String.format("Group with id=%s not found", id));
        }
    }

    @Override
    public GroupDTO update(GroupDTO groupDTO) {
        Group group = repository.findById(groupDTO.getId())
                .orElseThrow(() -> new IdNotFoundException("No such warehouse with ID " + groupDTO.getId()));
        if (group.isRemoved()) {
            throw new IdNotFoundException("Warehouse was deleted" + groupDTO.getId());
        }
        repository.save(mapper.toEntity(groupDTO));
        return groupDTO;
    }
}
