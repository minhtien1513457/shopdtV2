package com.example.shopdt.use_case.product.service;

import com.example.shopdt.use_case.manufacturer.repository.ManufacturerRepository;
import com.example.shopdt.use_case.manufacturer.service.ManufacturerService;
import com.example.shopdt.use_case.product.dto.ProductDto;
import com.example.shopdt.exception.NotFoundException;
import com.example.shopdt.use_case.product.maper.ProductMapper;
import com.example.shopdt.use_case.product.repository.ProductRepository;
import com.example.shopdt.use_case.product.request.CreateProductRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProdcutService {
    private final ProductRepository productRepository;
    private final ManufacturerService manufacturerService;


    @Override
    public void create(CreateProductRequest request) {
        manufacturerService.getByIdNoneNull(request.getManufacturerId());
        productRepository.save(ProductMapper.INSTANCE.map(request));
    }

    @Override
    public ProductDto findByIdAndTurnManufacturer(String id) {
        return productRepository.findByIdAndTurnBackProductDto(id)
                .orElseThrow(NotFoundException::new);
    }
}
