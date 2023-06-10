package com.example.shopdt.use_case.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
public class ProductInCartDto {
    private String id;
    private String name;
    private String description;
    private String status;
    private BigDecimal price;
    private Integer total;
    private String manufacturerId;
    private String manufacturerName;
    private Date createdDate;
    private Date updatedDate;
    private Integer amount;
}
