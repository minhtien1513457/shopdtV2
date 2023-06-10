package com.example.shopdt.use_case.cart_2_product.service;

import com.example.shopdt.use_case.cart.repository.CartRepository;
import com.example.shopdt.use_case.cart_2_product.maper.Cart2ProductMapper;
import com.example.shopdt.use_case.cart_2_product.repository.Cart2ProductRepository;
import com.example.shopdt.use_case.cart_2_product.request.AddProduct2CartRequest;
import com.example.shopdt.use_case.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Cart2ProductServiceImpl implements Cart2ProductService {
    private final Cart2ProductRepository cart2ProductRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @Override
    public void create(AddProduct2CartRequest request) {
        cartRepository.getByIdNoneNull(request.getCartId());
        productRepository.getByIdNoneNull(request.getCartId());
        cart2ProductRepository.save(Cart2ProductMapper.INSTANCE.map(request));
    }
}
