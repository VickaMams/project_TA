package com.kata.trade_accounting.service;

import com.kata.trade_accounting.model.LawDetails;
import com.kata.trade_accounting.repository.LawDetailsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class LawDetailsServiceImpl implements LawDetailsService {

    private final LawDetailsRepository repository;

    public LawDetailsServiceImpl(LawDetailsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LawDetails> findAll() {
        return repository.findAll();
    }

    @Override
    public LawDetails getById(Long id) {
        Optional<LawDetails> lawDetails = repository.findById(id);
        if (lawDetails.isPresent()) {
            return lawDetails.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @Transactional
    public LawDetails save(LawDetails lawDetails) {
        return repository.save(lawDetails);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public LawDetails update(LawDetails lawDetails) {
        return repository.save(lawDetails);
    }
}
