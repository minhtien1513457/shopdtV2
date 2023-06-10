package com.example.shopdt.use_case.cart.service;

import com.example.shopdt.use_case.cart.dto.CartDto;
import com.example.shopdt.use_case.cart.maper.CartMapper;
import com.example.shopdt.use_case.cart.repository.CartRepository;
import com.example.shopdt.use_case.cart.request.CreateCartRequest;
import com.example.shopdt.use_case.cart_2_product.repository.Cart2ProductRepository;
import com.example.shopdt.use_case.product.repository.ProductRepository;
import com.example.shopdt.use_case.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
