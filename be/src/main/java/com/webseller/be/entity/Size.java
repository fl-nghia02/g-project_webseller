package com.webseller.be.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "size")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @jakarta.validation.constraints.Size(max = 100)
    @NotNull
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @ColumnDefault("1")
    @Column(name = "status")
    private Integer status;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "create_at")
    private LocalDateTime createAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @jakarta.validation.constraints.Size(max = 255)
    @NotNull
    @Column(name = "create_by", nullable = false)
    private String createBy;

    @jakarta.validation.constraints.Size(max = 255)
    @NotNull
    @Column(name = "update_by", nullable = false)
    private String updateBy;

}