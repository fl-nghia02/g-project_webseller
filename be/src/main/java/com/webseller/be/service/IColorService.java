package com.webseller.be.service;

import com.webseller.be.dto.ColorDTO;
import com.webseller.be.entity.Color;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IColorService {
    Page<ColorDTO> findAllWithPage(Pageable pageable);

    Color findById(int id);

    Color findByName(String name);

    Color save(Color color);

    Color update(Color color);

    void delete(Color color);
}
