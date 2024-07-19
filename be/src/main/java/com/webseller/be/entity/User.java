package com.webseller.be.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "fullname", nullable = false)
    private String fullname;

    @Size(max = 255)
    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @Size(max = 255)
    @NotNull
    @Column(name = "hash_password", nullable = false)
    private String hashPassword;

    @Size(max = 50)
    @NotNull
    @Column(name = "phone_number", nullable = false, length = 50)
    private String phoneNumber;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "role")
    private Integer role;

    @Column(name = "status")
    private Integer status;

    @Column(name = "province_code")
    private Integer provinceCode;

    @Size(max = 100)
    @Column(name = "province_name", length = 100)
    private String provinceName;

    @Column(name = "district_code")
    private Integer districtCode;

    @Size(max = 100)
    @Column(name = "district_name", length = 100)
    private String districtName;

    @Column(name = "ward_code")
    private Integer wardCode;

    @Size(max = 100)
    @Column(name = "ward_name", length = 100)
    private String wardName;

    @Size(max = 255)
    @Column(name = "address_detail")
    private String addressDetail;

}