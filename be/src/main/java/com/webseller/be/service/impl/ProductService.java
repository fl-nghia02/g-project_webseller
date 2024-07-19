package com.webseller.be.service.impl;

import com.webseller.be.dto.ProductDTO;
import com.webseller.be.entity.Design;
import com.webseller.be.entity.Product;
import com.webseller.be.repository.CategoryRepo;
import com.webseller.be.repository.DesignRepo;
import com.webseller.be.repository.ProductRepo;
import com.webseller.be.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRepo productRepo;

    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    DesignRepo designRepo;

    @Override
    public List<Product> findAll() {
        return this.productRepo.findAll();
    }

    @Override
    public Page<Product> findAllWithPage(Pageable pageable) {
        return this.productRepo.findAll(pageable);
    }

    @Override
    public Product findById(int id) {
        return this.productRepo.findById(id).get();
    }

    @Override
    public Product findByName(String name) {
        return this.productRepo.findByName(name);
    }

    @Override
    public Product save(ProductDTO productDTO) {
        LocalDateTime now = LocalDateTime.now();
        Set<Design> designList = new HashSet<>();
        for (Integer designId : productDTO.getSetDesignId()) {
            Design design = designRepo.findById(designId).get();
            designList.add(design);
        }
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setCategory(this.categoryRepo.findById(productDTO.getCategoryId()).get());
        product.setDesigns(designList);
        product.setStatus(1);
        product.setCreateBy(productDTO.getCreateBy());
        product.setUpdateBy(productDTO.getUpdateBy());
        product.setCreateAt(now);
        product.setUpdateAt(now);
        return this.productRepo.save(product);
    }

    @Override
    public Product update(int id, ProductDTO productDTO) {
        Product product = this.productRepo.findById(id).get();
        product.setUpdateAt(LocalDateTime.now());
        product.setName(productDTO.getName());
        product.setCategory(this.categoryRepo.findById(productDTO.getCategoryId()).get());
        product.setStatus(productDTO.getStatus());
        return this.productRepo.save(product);
    }

    @Override
    public void delete(Product product) {

    }
}
