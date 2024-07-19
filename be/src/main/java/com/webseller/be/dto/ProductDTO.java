package com.webseller.be.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
    private Integer id;
    private String name;
    private Integer status;
    private Integer categoryId;
    private Set<Integer> setDesignId;
    private String createAt;
    private String updateAt;
    private String createBy;
    private String updateBy;
}
