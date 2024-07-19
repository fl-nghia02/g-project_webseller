package com.webseller.be.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_detail_id")
    private ProductDetail productDetail;

    @Size(max = 255)
    @NotNull
    @Column(name = "path", nullable = false)
    private String path;

    @NotNull
    @Column(name = "is_avatar", nullable = false)
    private Boolean isAvatar = false;

}