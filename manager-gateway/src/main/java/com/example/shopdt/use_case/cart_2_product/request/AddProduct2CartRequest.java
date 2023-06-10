package com.example.shopdt.use_case.cart_2_product.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddProduct2CartRequest {
    @NotEmpty
    private String cartId;

    @NotEmpty
    private String productId;

    @Positive
    private Integer amount;
}
