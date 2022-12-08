package com.kata.trade_accounting.service;


import com.kata.trade_accounting.dto.ProductPackagingDto;
import com.kata.trade_accounting.exception.NotFoundByIdException;
import com.kata.trade_accounting.mapper.ProductPackagingDtoMapper;
import com.kata.trade_accounting.mapper.ProductPackingMapper;
import com.kata.trade_accounting.repository.ProductPackagingDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductPackagingServiceImpl implements ProductPackagingService {

    private final ProductPackagingDao productPackagingDao;
    private final ProductPackagingDtoMapper productPackagingDtoMapper;

    private final ProductPackingMapper productPackagingMapper;

    public ProductPackagingServiceImpl(ProductPackagingDao productPackagingDao,
                                       ProductPackagingDtoMapper productPackagingDtoMapper,
                                       ProductPackingMapper productPackagingMapper) {
        this.productPackagingDao = productPackagingDao;
        this.productPackagingDtoMapper = productPackagingDtoMapper;
        this.productPackagingMapper = productPackagingMapper;
    }


    @Override
    public List<ProductPackagingDto> findAll() {

        return productPackagingDao.findAll()
                .stream().map(productPackagingDtoMapper::toProductPackagingDto)
                .toList();
    }

    @Override
    public void addProductPackaging(ProductPackagingDto productPackagingDto) {
        productPackagingDao.saveAndFlush(productPackagingMapper.toProductPackaging(productPackagingDto));
    }

    @Override
    public void removeProductPackaging(Long id) {
        if (findById(id) != null) {
            productPackagingDao.deleteById(id);
        } else {
            throw new NotFoundByIdException("Фасовка товара запрашиваемого вида не найдена");
        }
    }

    @Override
    public ProductPackagingDto findById(Long id) {
        return productPackagingDtoMapper.toProductPackagingDto(productPackagingDao.findById(id).orElse(null));
    }
}
