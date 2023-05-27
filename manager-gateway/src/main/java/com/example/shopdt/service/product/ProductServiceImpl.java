package com.example.shopdt.service.product;

import com.example.shopdt.dto.ProductDto;
import com.example.shopdt.dto.UserDto;
import com.example.shopdt.exception.NotFoundException;
import com.example.shopdt.maper.UserMapper;
import com.example.shopdt.repository.product.ProductRepository;
import com.example.shopdt.repository.user.UserRepository;
import com.example.shopdt.request.product.CreateProductRequest;
import com.example.shopdt.request.user.CreateUserRequest;
import com.example.shopdt.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProdcutService {
    private final ProductRepository productRepository;


    @Override
    public void create(CreateProductRequest request) {

    }

    @Override
    public ProductDto findByIdAndTurnManufacturer(String id) {
        return productRepository.findByIdAndTurnManufacturer(id)
                .orElseThrow(NotFoundException::new);
    }
}
