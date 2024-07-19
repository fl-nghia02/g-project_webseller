package com.webseller.be.repository;

import com.webseller.be.entity.Color;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepo extends JpaRepository<Color, Integer> {
    Page<Color> findAll(Pageable pageable);
    Color findByName(String name);
}
