package com.webseller.be.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
public class OrderItemDTO {
    private Integer id;
    private Integer orderId;
    private Integer productDetailId;
    private Integer quantity;
    private BigDecimal price;
    private Integer discount;
    private String createAt;
    private String updateAt;
    private String createBy;
    private String updateBy;
}
