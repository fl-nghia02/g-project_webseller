package com.webseller.be.controller.admin;

import com.webseller.be.dto.CategoryDTO;
import com.webseller.be.dto.MapToDTO.MapEntityToDTO;
import com.webseller.be.entity.Category;
import com.webseller.be.service.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<?> getAllCategory(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "20") int size) throws InterruptedException {
//        Thread.sleep(2000);
        Pageable pageable = PageRequest.of(page, size);
        Page<CategoryDTO> categoryPageDTO = categoryService.findAllWithPage(pageable);
        return ResponseEntity.ok(categoryPageDTO);
    }

    @PostMapping("create")
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO) {
        if (categoryDTO.getName().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tên danh mục không được để trống");
        }
        if (this.categoryService.findByName(categoryDTO.getName()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Đã tồn tại danh mục");
        }
        Category category = modelMapper.map(categoryDTO, Category.class);
        category = categoryService.save(category);
        CategoryDTO newCategoryDTO = MapEntityToDTO.mapCategoryToCategoryDTO(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCategoryDTO);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable int id, @RequestBody CategoryDTO categoryDTO) {
        Category oldCategory = this.categoryService.findById(id);
        if (categoryDTO.getName().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tên danh mục không được để trống");
        }
        if (this.categoryService.findByName(categoryDTO.getName()) != null
                && !oldCategory.getName().equals(categoryDTO.getName())
        ) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Đã tồn tại danh mục");
        }

        oldCategory.setName(categoryDTO.getName());
        oldCategory.setStatus(categoryDTO.getStatus());
        oldCategory.setUpdateBy(categoryDTO.getUpdateBy());

        Category newCategory = categoryService.update(oldCategory);
        CategoryDTO newCategoryDTO = MapEntityToDTO.mapCategoryToCategoryDTO(newCategory);
        return ResponseEntity.status(HttpStatus.OK).body(newCategoryDTO);
    }
}
