package com.webseller.be.repository;

import com.webseller.be.entity.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface ProductDetailRepo extends JpaRepository<ProductDetail, Integer> {
    List<ProductDetail> findByProductId(int productId);
}
