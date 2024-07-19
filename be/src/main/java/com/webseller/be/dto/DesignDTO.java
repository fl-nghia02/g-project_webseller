package com.webseller.be.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class DesignDTO {
    private Integer id;
    private String name;
    private Integer status;
    private String createAt;
    private String updateAt;
    private String createBy;
    private String updateBy;
}
