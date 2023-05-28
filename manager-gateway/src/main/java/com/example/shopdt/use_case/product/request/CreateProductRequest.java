package com.example.shopdt.use_case.product.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
    @NotEmpty
    private String name;

    private String description;

    @NotEmpty
    private String status;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer total;

    @NotEmpty
    private String manufacturerId;
}
