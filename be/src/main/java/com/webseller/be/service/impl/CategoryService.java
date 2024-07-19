package com.webseller.be.service.impl;

import com.webseller.be.dto.CategoryDTO;
import com.webseller.be.dto.MapToDTO.MapEntityToDTO;
import com.webseller.be.entity.Category;
import com.webseller.be.repository.CategoryRepo;
import com.webseller.be.service.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public Page<CategoryDTO> findAllWithPage(Pageable pageable) {
        Page<Category> pageCate = this.categoryRepo.findAll(pageable);
        return pageCate.map((cate)-> MapEntityToDTO.mapCategoryToCategoryDTO(cate));
    }

    @Override
    public Category findById(int id) {
        return this.categoryRepo.findById(id).orElse(null);
    }

    @Override
    public Category findByName(String name) {
        return this.categoryRepo.findByName(name);
    }

    @Override
    public Category save(Category category) {
        LocalDateTime now = LocalDateTime.now();
        category.setCreateAt(now);
        category.setUpdateAt(now);
        category.setStatus(1);
        return this.categoryRepo.save(category);
    }

    @Override
    public Category update( Category category) {
        category.setUpdateAt(LocalDateTime.now());
        return this.categoryRepo.save(category);
    }

    @Override
    public void delete(Category category) {

    }
}
