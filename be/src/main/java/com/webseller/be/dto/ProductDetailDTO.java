package com.webseller.be.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
public class ProductDetailDTO {
    private Integer id;
    private Integer productId;
    private Integer quantity;
    private BigDecimal importPrice;
    private BigDecimal price;
    private Integer status;
    private Integer colorId;
    private Integer sizeId;
    private String createAt;
    private String updateAt;
    private String createBy;
    private String updateBy;
}
