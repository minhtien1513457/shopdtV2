package com.example.shopdt.use_case.cart.service;

import com.example.shopdt.exception.NotFoundException;
import com.example.shopdt.repository.Cart2ProductRepository;
import com.example.shopdt.use_case.cart.dto.CartDto;
import com.example.shopdt.use_case.cart.entity.CartEntity;
import com.example.shopdt.use_case.cart.maper.CartMapper;
import com.example.shopdt.use_case.cart.repository.CartRepository;
import com.example.shopdt.use_case.cart.request.AddProduct2CartRequest;
import com.example.shopdt.use_case.cart.request.CreateCartRequest;
import com.example.shopdt.use_case.product.repository.ProductRepository;
import com.example.shopdt.use_case.product.service.ProductService;
import com.example.shopdt.use_case.user.repository.UserRepository;
import com.example.shopdt.use_case.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService{
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final Cart2ProductRepository cart2ProductRepository;

    @Override
    @Transactional
    public void create(CreateCartRequest request) {
        userRepository.getByIdNoneNull(request.getUserId());
        cartRepository.save(CartMapper.INSTANCE.map(request));
    }

    @Override
    public CartDto getByUserId(String userId) {
        return null;
    }

    @Override
    @Transactional
    public void addProduct2Cart(AddProduct2CartRequest request) {
        cartRepository.getByIdNoneNull(request.getCartId());
        productRepository.getByIdNoneNull(request.getCartId());
    }
}
