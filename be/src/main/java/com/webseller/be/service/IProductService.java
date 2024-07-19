package com.webseller.be.service;

import com.webseller.be.dto.ProductDTO;
import com.webseller.be.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Page<Product> findAllWithPage(Pageable pageable);

    Product findById(int id);

    Product findByName(String name);

    Product save(ProductDTO productDTO);

    Product update(int id,ProductDTO productDTO);

    void delete(Product size);
}
