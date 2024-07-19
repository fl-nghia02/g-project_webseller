package com.webseller.be.service;

import com.webseller.be.dto.ProductDetailDTO;
import com.webseller.be.entity.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductDetailService {
    Page<ProductDetail> findAllProductDetail(int page, int pageSize);
    List<ProductDetail> findAllProductDetail();
    ProductDetail getProductDetailById(int id);
    ProductDetail updateProductDetail(int id, ProductDetailDTO productDetailDTO);
    ProductDetail addProductDetail(ProductDetailDTO productDetailDTO);
    List<ProductDetail> addAllProductDetail(List<ProductDetailDTO> productDetailDTOList);
    void deleteProductDetail(int id);
}
