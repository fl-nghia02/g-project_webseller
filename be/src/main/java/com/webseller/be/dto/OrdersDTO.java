package com.webseller.be.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
public class OrdersDTO {
    private Integer id;
    private Integer userId;
    private String fullname;
    private String phoneNumber;
    private Integer provinceCode;
    private String provinceName;
    private Integer districtCode;
    private String districtName;
    private Integer wardCode;
    private String wardName;
    private String addressDetail;
    private BigDecimal totalPrice;
    private Integer status;
    private String createAt;
    private String updateAt;
    private String createBy;
    private String updateBy;
}
