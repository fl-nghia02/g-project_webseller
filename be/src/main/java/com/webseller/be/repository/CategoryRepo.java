package com.webseller.be.repository;

import com.webseller.be.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
    Page<Category> findAll(Pageable pageable);
    Category findByName(String name);
}
