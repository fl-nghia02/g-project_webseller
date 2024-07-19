package com.webseller.be.service;

import com.webseller.be.dto.CategoryDTO;
import com.webseller.be.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
    Page<CategoryDTO> findAllWithPage(Pageable pageable);

    Category findById(int id);

    Category findByName(String name);

    Category save(Category category);

    Category update(Category category);

    void delete(Category category);
}
