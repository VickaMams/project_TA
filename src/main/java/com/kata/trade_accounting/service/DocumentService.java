package com.kata.trade_accounting.service;

import com.kata.trade_accounting.dto.DocumentDTO;

import java.util.Date;
import java.util.List;

public interface DocumentService {

    List<DocumentDTO> findAll();

    List<DocumentDTO> findAllInBasket();

    DocumentDTO getById(Long id);

    DocumentDTO save(DocumentDTO dto);

    void deleteById(Long id);

    void setDateOfDeletion(Long id);

    void resetDateOfDeletion(Long id);

    DocumentDTO edit(Long id, DocumentDTO dto);
}
