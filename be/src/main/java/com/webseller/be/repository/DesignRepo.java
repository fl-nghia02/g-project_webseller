package com.webseller.be.repository;

import com.webseller.be.entity.Design;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignRepo extends JpaRepository<Design, Integer> {
    Page<Design> findAll(Pageable pageable);
    Design findByName(String name);
}
