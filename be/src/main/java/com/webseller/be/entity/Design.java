package com.webseller.be.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@Table(name = "design")
@Getter
@Setter
public class Design {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

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