package com.webseller.be.service.impl;

import com.webseller.be.dto.ProductDetailDTO;
import com.webseller.be.entity.ProductDetail;
import com.webseller.be.repository.*;
import com.webseller.be.service.IProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDetailService implements IProductDetailService {
    @Autowired
    ProductDetailRepo productDetailRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    ColorRepo colorRepo;
    @Autowired
    DesignRepo designRepo;
    @Autowired
    SizeRepo sizeRepo;

    @Override
    public Page<ProductDetail> findAllProductDetail(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.productDetailRepo.findAll(pageable);
    }

    @Override
    public List<ProductDetail> findAllProductDetail() {
        return this.productDetailRepo.findAll();
    }

    @Override
    public ProductDetail getProductDetailById(int id) {
        return this.productDetailRepo.findById(id).get();
    }

    @Override
    public ProductDetail addProductDetail(ProductDetailDTO productDetailDTO) {
        LocalDateTime now = LocalDateTime.now();
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProduct(this.productRepo.findById(productDetailDTO.getProductId()).get());
        productDetail.setQuantity(productDetailDTO.getQuantity());
        productDetail.setPrice(productDetailDTO.getPrice());
        productDetail.setImportPrice(productDetailDTO.getImportPrice());
        productDetail.setStatus(1);
        productDetail.setColor(this.colorRepo.findById(productDetailDTO.getColorId()).get());
        productDetail.setSize(this.sizeRepo.findById(productDetailDTO.getSizeId()).get());
        productDetail.setCreateAt(now);
        productDetail.setUpdateAt(now);
        productDetail.setCreateBy(productDetailDTO.getCreateBy());
        productDetail.setUpdateBy(productDetailDTO.getUpdateBy());
        return this.productDetailRepo.save(productDetail);
    }

    @Override
    public List<ProductDetail> addAllProductDetail(List<ProductDetailDTO> productDetailDTOList) {
        List<ProductDetail> productDetailList = new ArrayList<>();
        for (ProductDetailDTO productDetailDTO : productDetailDTOList) {
            LocalDateTime now = LocalDateTime.now();
            ProductDetail productDetail = new ProductDetail();
            productDetail.setProduct(this.productRepo.findById(productDetailDTO.getProductId()).get());
            productDetail.setQuantity(productDetailDTO.getQuantity());
            productDetail.setPrice(productDetailDTO.getPrice());
            productDetail.setImportPrice(productDetailDTO.getImportPrice());
            productDetail.setStatus(1);
            productDetail.setColor(this.colorRepo.findById(productDetailDTO.getColorId()).get());
            productDetail.setSize(this.sizeRepo.findById(productDetailDTO.getSizeId()).get());
            productDetail.setCreateAt(now);
            productDetail.setUpdateAt(now);
            productDetail.setCreateBy(productDetailDTO.getCreateBy());
            productDetail.setUpdateBy(productDetailDTO.getUpdateBy());
            productDetailList.add(productDetail);
        }
        return this.productDetailRepo.saveAll(productDetailList);
    }


    @Override
    public ProductDetail updateProductDetail(int id, ProductDetailDTO productDetailDTO) {
        ProductDetail productDetail = this.productDetailRepo.findById(id).get();
        productDetail.setQuantity(productDetailDTO.getQuantity());
        productDetail.setPrice(productDetailDTO.getPrice());
        productDetail.setImportPrice(productDetailDTO.getImportPrice());
        productDetail.setStatus(productDetailDTO.getStatus());
        productDetail.setUpdateBy(productDetailDTO.getUpdateBy());
        productDetail.setUpdateAt(LocalDateTime.now());
        return this.productDetailRepo.save(productDetail);
    }

    @Override
    public void deleteProductDetail(int id) {

    }
}
