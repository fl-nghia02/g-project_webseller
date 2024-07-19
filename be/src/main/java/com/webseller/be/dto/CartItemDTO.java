package com.webseller.be.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartItemDTO {
    private Integer id;
    private Integer cartId;
    private Integer productDetailId;
    private Integer quantity;
}
