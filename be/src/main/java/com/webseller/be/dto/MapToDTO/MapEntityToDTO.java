package com.webseller.be.dto.MapToDTO;

import com.webseller.be.dto.*;
import com.webseller.be.entity.*;
import com.webseller.be.util.ConvertTime;

public class MapEntityToDTO {
//    public static ProductDTO mapProductToProductDTO(Product product) {
//        ProductDTO productDTO = new ProductDTO();
//        productDTO.setId(product.getId());
//        productDTO.setName(product.getName());
//    }

    public static CategoryDTO mapCategoryToCategoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setStatus(category.getStatus());
        categoryDTO.setCreateBy(category.getCreateBy());
        categoryDTO.setUpdateBy(category.getUpdateBy());
        categoryDTO.setCreateAt(ConvertTime.convertLocalDateTimeToString(category.getCreateAt()));
        categoryDTO.setUpdateAt(ConvertTime.convertLocalDateTimeToString(category.getUpdateAt()));
        return categoryDTO;
    }

    public static ColorDTO mapColorToColorDTO(Color color) {
        ColorDTO colorDTO = new ColorDTO();
        colorDTO.setId(color.getId());
        colorDTO.setName(color.getName());
        colorDTO.setStatus(color.getStatus());
        colorDTO.setCreateBy(color.getCreateBy());
        colorDTO.setUpdateBy(color.getUpdateBy());
        colorDTO.setCreateAt(ConvertTime.convertLocalDateTimeToString(color.getCreateAt()));
        colorDTO.setUpdateAt(ConvertTime.convertLocalDateTimeToString(color.getUpdateAt()));
        return colorDTO;
    }
    public static DesignDTO mapDesignToDesignDTO(Design design) {
        DesignDTO designDTO = new DesignDTO();
        designDTO.setId(design.getId());
        designDTO.setName(design.getName());
        designDTO.setStatus(design.getStatus());
        designDTO.setCreateBy(design.getCreateBy());
        designDTO.setUpdateBy(design.getUpdateBy());
        designDTO.setCreateAt(ConvertTime.convertLocalDateTimeToString(design.getCreateAt()));
        designDTO.setUpdateAt(ConvertTime.convertLocalDateTimeToString(design.getUpdateAt()));
        return designDTO;
    }
    public static SizeDTO mapSizeToSizeDTO(Size size) {
        SizeDTO sizeDTO = new SizeDTO();
        sizeDTO.setId(size.getId());
        sizeDTO.setName(size.getName());
        sizeDTO.setStatus(size.getStatus());
        sizeDTO.setCreateBy(size.getCreateBy());
        sizeDTO.setUpdateBy(size.getUpdateBy());
        sizeDTO.setCreateAt(ConvertTime.convertLocalDateTimeToString(size.getCreateAt()));
        sizeDTO.setUpdateAt(ConvertTime.convertLocalDateTimeToString(size.getUpdateAt()));
        return sizeDTO;
    }
}
