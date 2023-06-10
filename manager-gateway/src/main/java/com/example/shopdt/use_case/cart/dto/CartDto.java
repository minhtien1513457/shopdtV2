package com.example.shopdt.use_case.cart.dto;

import com.example.shopdt.use_case.product.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
public class CartDto {
    private String id;
    private String username;
    private String email;
    private String roleName;
    private Date createdDate;
    private Date updatedDate;
    private List<ProductDto> products;
}
