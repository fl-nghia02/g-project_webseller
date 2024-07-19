package com.webseller.be.service;

import com.webseller.be.dto.DesignDTO;
import com.webseller.be.entity.Design;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDesignService {
    Page<DesignDTO> findAllWithPage(Pageable pageable);

    Design findById(int id);

    Design findByName(String name);

    Design save(Design design);

    Design update(Design design);

    void delete(Design design);
}
