package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.SalesChannelDTO;
import com.kata.trade_accounting.exception.IdNotFoundException;
import com.kata.trade_accounting.exception.ModelDeletedException;
import com.kata.trade_accounting.mapper.SalesChannelMapper;
import com.kata.trade_accounting.model.SalesChannel;
import com.kata.trade_accounting.repository.SalesChannelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
@AllArgsConstructor
public class SalesChannelServiceImpl implements SalesChannelService{

    private final SalesChannelRepository repository;

    private final SalesChannelMapper mapper;

    @Override
    public List<SalesChannelDTO> findAll() {
        return repository.findAll().stream()
                .filter(Predicate.not(SalesChannel::isRemoved))
                .map(mapper::toDto).toList();
    }

    @Override
    public SalesChannelDTO getById(Long id) {
        Optional<SalesChannel> salesChannel = repository.findById(id);
        if (salesChannel.isPresent()) {
            return mapper.toDto(salesChannel.get());
        } else {
            throw new IdNotFoundException(String.format("Sales Channel with id = %s not found", id));
        }
    }

    @Override
    @Transactional
    public SalesChannelDTO save(SalesChannelDTO dto) {
        SalesChannel salesChannel = repository.save(mapper.toEntity(dto));
        salesChannel.setRemoved(false);
        return mapper.toDto(salesChannel);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Optional<SalesChannel> salesChannel = repository.findById(id);
        if (salesChannel.isPresent()) {
            if (salesChannel.get().isRemoved()) {
                throw new ModelDeletedException(String.format("Sales Channel with id = %s already deleted", id));
            }
            repository.setRemovedTrue(id);
        } else {
            throw new IdNotFoundException(String.format("Sales Channel with id = %s not found", id));
        }
    }

    @Override
    @Transactional
    public SalesChannelDTO edit(Long id, SalesChannelDTO dto) {
        Optional<SalesChannel> salesChannel = repository.findById(id);
        if (salesChannel.isPresent()) {
            if (salesChannel.get().isRemoved()) {
                throw new ModelDeletedException(String.format("Sales Channel with id = %s already deleted", id));
            }
            dto.setId(id);
            return save(dto);
        } else {
            throw new IdNotFoundException(String.format("Sales Channel with id = %s not found", id));
        }
    }
}
