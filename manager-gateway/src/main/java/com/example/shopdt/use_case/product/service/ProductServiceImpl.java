package com.example.shopdt.use_case.product.service;

import com.example.shopdt.exception.NotFoundException;
import com.example.shopdt.use_case.manufacturer.repository.ManufacturerRepository;
import com.example.shopdt.use_case.manufacturer.service.ManufacturerService;
import com.example.shopdt.use_case.product.dto.ProductDto;
import com.example.shopdt.use_case.product.entity.ProductEntity;
import com.example.shopdt.use_case.product.maper.ProductMapper;
import com.example.shopdt.use_case.product.repository.ProductRepository;
import com.example.shopdt.use_case.product.request.CreateProductRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ManufacturerRepository manufacturerRepository;


    @Override
    public void create(CreateProductRequest request) {
        manufacturerRepository.getByIdNoneNull(request.getManufacturerId());
        productRepository.save(ProductMapper.INSTANCE.map(request));
    }

    @Override
    public ProductDto findByIdAndTurnManufacturer(String id) {
        return productRepository.findByIdAndTurnBackProductDto(id)
                .orElseThrow(NotFoundException::new);
    }
}
