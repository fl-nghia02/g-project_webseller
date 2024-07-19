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
@Table(name = "product_detail")
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @NotNull
    @Column(name = "import_price", nullable = false, precision = 10)
    private BigDecimal importPrice;

    @NotNull
    @Column(name = "price", nullable = false, precision = 10)
    private BigDecimal price;

    @ColumnDefault("1")
    @Column(name = "status")
    private Integer status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "size_id")
    private com.webseller.be.entity.Size size;

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