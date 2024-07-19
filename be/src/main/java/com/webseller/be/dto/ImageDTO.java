package com.webseller.be.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ImageDTO {
    private Integer id;
    private Integer productDetailId;
    private String path;
    private Byte isAvatar;
}
