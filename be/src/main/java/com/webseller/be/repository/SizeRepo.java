package com.webseller.be.repository;

import com.webseller.be.entity.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepo extends JpaRepository<Size, Integer> {
    Page<Size> findAll(Pageable pageable);
    Size findByName(String name);
}
