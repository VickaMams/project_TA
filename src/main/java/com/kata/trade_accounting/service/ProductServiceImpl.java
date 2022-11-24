package com.kata.trade_accounting.service;


import com.kata.trade_accounting.dto.ProductDTO;
import com.kata.trade_accounting.exception.IdNotFoundException;
import com.kata.trade_accounting.exception.ProductNotFoundException;
import com.kata.trade_accounting.controller.mapper.ProductMapper;
import com.kata.trade_accounting.model.Product;
import com.kata.trade_accounting.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    private final ProductRepository repository;
    private final ProductMapper mapper;
    @Override
    public List<ProductDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    public ProductDTO getById(Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ProductNotFoundException(String.format("Product with id=%s not found", id))));
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        repository.save(mapper.toEntity(productDTO));
        return productDTO;
    }

    @Override
    public void deleteById(Long id) {
        int i = repository.setRemovedTrue(id);
        if (i == 0) {
            throw new ProductNotFoundException(String.format("Product with id=%s not found", id));
        }
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        Product product = repository.findById(productDTO.getId())
                .orElseThrow(() -> new IdNotFoundException("No such warehouse with ID " + productDTO.getId()));
        if (product.isRemoved()) {
            throw new IdNotFoundException("Warehouse was deleted" + productDTO.getId());
        }
        repository.save(mapper.toEntity(productDTO));
        return productDTO;
    }
}
