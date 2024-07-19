package com.webseller.be.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {
    private Integer id;
    private String name;

    private Integer status;
    private String createAt;
    private String updateAt;
    private String createBy;
    private String updateBy;
}
