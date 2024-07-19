package com.webseller.be.controller.admin;

import com.webseller.be.dto.ProductDTO;
import com.webseller.be.entity.Design;
import com.webseller.be.entity.Product;
import com.webseller.be.service.IProductDetailService;
import com.webseller.be.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping("api/admin/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private IProductDetailService productDetailService;

    @GetMapping
    public ResponseEntity<?> getAllProduct(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "100") int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Product> productPage = this.productService.findAllWithPage(pageable);
        return ResponseEntity.ok(productPage);
    }

    @PostMapping("create")
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO) {
        try {
            if (productDTO.getName().isBlank()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tên sản phẩm không thể trống");
            }

            Set<Integer> setDesignId = productDTO.getSetDesignId();
            Product product = this.productService.findByName(productDTO.getName());
            Boolean checked = false;
            if (product != null) {
                Set<Design> setDesign = product.getDesigns();

                if (setDesignId != null && setDesignId.size() > 0) {
                    for (Design design : setDesign) {
                        if (setDesignId.contains(design.getId())) {
                            checked = true;
                        }
                    }
                }
            }
            if (this.productService.findByName(productDTO.getName()) != null && checked &&
                    product.getCategory().getId() != productDTO.getCategoryId()
            ) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Đã tồn tại sản phẩm");
            }
            Product newProduct = this.productService.save(productDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi");
        }

    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id") int id, @RequestBody ProductDTO productDTO) {
        Product oldProduct = this.productService.findById(id);
        if (productDTO.getName().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tên sản phẩm không thể trống");
        }
        if (this.productService.findByName(productDTO.getName()) != null &&
                !oldProduct.getName().equals(productDTO.getName()) &&
                !(Objects.equals(oldProduct.getCategory().getId(), productDTO.getCategoryId()))
        ) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Đã tồn tại sản phẩm");
        }
        Product newProduct = this.productService.update(id, productDTO);
        return ResponseEntity.status(HttpStatus.OK).body(newProduct);
    }
}
