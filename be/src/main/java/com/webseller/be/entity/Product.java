package com.webseller.be.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @ColumnDefault("1")
    @Column(name = "status")
    private Integer status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "product_design",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "design_id")
    )
//    @Cascade(CascadeType.REMOVE)
    private Set<Design> designs;

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