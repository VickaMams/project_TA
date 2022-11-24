package com.kata.trade_accounting.mapper;

import com.kata.trade_accounting.dto.GroupDTO;
import com.kata.trade_accounting.model.Group;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GroupMapper {

    private final ModelMapper mapper;

    public GroupDTO toDTO(Group group) {
        return mapper.map(group, GroupDTO.class);
    }

    public Group toEntity(GroupDTO groupDTO) {
        return mapper.map(groupDTO, Group.class);
    }
}
