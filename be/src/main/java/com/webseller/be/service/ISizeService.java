package com.webseller.be.service;

import com.webseller.be.dto.SizeDTO;
import com.webseller.be.entity.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISizeService {
    Page<SizeDTO> findAllWithPage(Pageable pageable);

    Size findById(int id);

    Size findByName(String name);

    Size save(Size size);

    Size update(Size size);

    void delete(Size size);
}
