package com.kata.trade_accounting.mapper;

import com.kata.trade_accounting.dto.DocumentDTO;
import com.kata.trade_accounting.model.Document;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DocumentMapper {

    private final ModelMapper mapper;

    public DocumentDTO toDto(Document document) {
        return mapper.map(document, DocumentDTO.class);
    }

    public Document toEntity(DocumentDTO dto) {
        return mapper.map(dto, Document.class);
    }
}
