package com.webseller.be.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDesignDTO {
    private Integer id;
    private Integer productId;
    private Integer designId;
}
