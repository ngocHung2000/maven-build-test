package com.vn.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private Integer id;
    private String nameProduct;
    private BigDecimal price;
    private String description;
}
