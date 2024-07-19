package com.webseller.be.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Size(max = 255)
    @NotNull
    @Column(name = "fullname", nullable = false)
    private String fullname;

    @Size(max = 20)
    @NotNull
    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @NotNull
    @Column(name = "province_code", nullable = false)
    private Integer provinceCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "province_name", nullable = false, length = 100)
    private String provinceName;

    @NotNull
    @Column(name = "district_code", nullable = false)
    private Integer districtCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "district_name", nullable = false, length = 100)
    private String districtName;

    @NotNull
    @Column(name = "ward_code", nullable = false)
    private Integer wardCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "ward_name", nullable = false, length = 100)
    private String wardName;

    @Size(max = 255)
    @NotNull
    @Column(name = "address_detail", nullable = false)
    private String addressDetail;

    @Column(name = "total_price", precision = 10)
    private BigDecimal totalPrice;

    @Column(name = "status")
    private Integer status;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "create_at")
    private LocalDateTime createAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @Size(max = 255)
    @NotNull
    @Column(name = "create_by", nullable = false)
    private String createBy;

    @Size(max = 255)
    @NotNull
    @Column(name = "update_by", nullable = false)
    private String updateBy;

}