package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.DocumentDTO;
import com.kata.trade_accounting.exception.IdNotFoundException;
import com.kata.trade_accounting.exception.ModelDeletedException;
import com.kata.trade_accounting.mapper.DocumentMapper;
import com.kata.trade_accounting.model.Document;
import com.kata.trade_accounting.repository.DocumentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
@AllArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository repository;

    private final DocumentMapper mapper;

    @Override
    public List<DocumentDTO> findAll() {
        return repository.findAll().stream()
                .filter(Predicate.not(Document::isRemoved))
                .filter(document -> document.getDateOfDeletion() == null)
                .map(mapper::toDto).toList();
    }

    @Override
    public List<DocumentDTO> findAllInBasket() {
        return repository.findAll().stream()
                .filter(document -> document.getDateOfDeletion() != null)
                .map(document -> {
                    if (document.getDateOfDeletion().after(new Date())) {
                        document.setDateOfDeletion(null);
                        document.setRemoved(true);
                        repository.resetDateOfDeletion(null);
                        repository.setRemovedTrue(document.getId());
                    }
                    return document;
                })
                .filter(Predicate.not(Document::isRemoved))
                .map(mapper::toDto).toList();
    }

    @Override
    public DocumentDTO getById(Long id) {
        Optional<Document> document = repository.findById(id);
        if (document.isPresent()) {
            return mapper.toDto(document.get());
        } else {
            throw new IdNotFoundException(String.format("Document with id = %s not found", id));
        }
    }

    @Override
    public DocumentDTO save(DocumentDTO dto) {
        Document document = repository.save(mapper.toEntity(dto));
        return mapper.toDto(document);
    }

    @Override
    public void deleteById(Long id) {
        int i = repository.setRemovedTrue(id);
        if (i == 0) {
            throw new IdNotFoundException(String.format("Document with id = %s not found", id));
        }
    }

    @Override
    public void setDateOfDeletion(Long id) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 7);
        int i = repository.setDateOfDeletion(id, calendar.getTime());
        if (i == 0) {
            throw new IdNotFoundException(String.format("Document with id = %s not found", id));
        }
    }

    @Override
    public void resetDateOfDeletion(Long id) {
        int i = repository.resetDateOfDeletion(id);
        if (i == 0) {
            throw new IdNotFoundException(String.format("Document with id = %s not found", id));
        }
    }

    @Override
    public DocumentDTO edit(Long id, DocumentDTO dto) {
        Optional<Document> document = repository.findById(id);
        if (document.isPresent()) {
            if (document.get().isRemoved()) {
                throw new ModelDeletedException(String.format("Document with id = %s already deleted", id));
            }
            dto.setId(id);
            return save(dto);
        } else {
            throw new IdNotFoundException(String.format("Document with id = %s not found", id));
        }
    }
}
