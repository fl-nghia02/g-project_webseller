package com.webseller.be.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Integer id;
    private String fullname;
    private String email;
    private String hashPassword;
    private String phoneNumber;
    private Integer gender;
    private Integer role;
    private Integer status;
    private Integer provinceCode;
    private String provinceName;
    private Integer districtCode;
    private String districtName;
    private Integer wardCode;
    private String wardName;
    private String addressDetail;
}
