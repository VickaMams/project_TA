package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.LawDetailsDTO;
import com.kata.trade_accounting.exception.LawDetailsNotFoundException;
import com.kata.trade_accounting.mapper.LawDetailsMapper;
import com.kata.trade_accounting.model.LawDetails;
import com.kata.trade_accounting.repository.LawDetailsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class LawDetailsServiceImpl implements LawDetailsService {

    @PersistenceContext
    private EntityManager entityManager;

    private final LawDetailsRepository repository;

    private final LawDetailsMapper mapper;

    public LawDetailsServiceImpl(LawDetailsRepository repository, LawDetailsMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<LawDetailsDTO> findAll() {
        return repository.findAll()
                .stream().map(mapper::toDto).toList();
    }

    @Override
    public LawDetailsDTO getById(Long id) {
        Optional<LawDetails> lawDetails = repository.findById(id);
        if (lawDetails.isPresent()) {
            return mapper.toDto(lawDetails.get());
        } else {
            throw new LawDetailsNotFoundException(String.format("Law Details with id=%s not found", id));
        }
    }

    @Override
    @Transactional
    public LawDetailsDTO save(LawDetailsDTO dto) {
        LawDetails entity = repository.save(mapper.toEntity(dto));
        entity.setRemoved(false);
        return mapper.toDto(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        int i = entityManager.createQuery("update LawDetails set removed = true where id = ?1")
                .setParameter(1, id)
                .executeUpdate();
        if (i==0){
            throw new LawDetailsNotFoundException(String.format("Law Details with id=%s not found", id));
        }
    }

    @Override
    @Transactional
    public LawDetailsDTO edit(Long id, LawDetailsDTO dto) {
        Optional<LawDetails> lawDetails = repository.findById(id);
        if (lawDetails.isPresent()) {
            dto.setId(id);
            return save(dto);
        } else {
            throw new LawDetailsNotFoundException(String.format("Law Details with id=%s not found", id));
        }
    }
}
