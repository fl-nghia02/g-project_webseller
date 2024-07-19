package com.webseller.be.service.impl;

import com.webseller.be.dto.ColorDTO;
import com.webseller.be.dto.MapToDTO.MapEntityToDTO;
import com.webseller.be.entity.Color;
import com.webseller.be.repository.ColorRepo;
import com.webseller.be.service.IColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ColorService implements IColorService {
    @Autowired
    ColorRepo colorRepo;
    @Override
    public Page<ColorDTO> findAllWithPage(Pageable pageable) {
        Page<Color> pageCate = this.colorRepo.findAll(pageable);
        return pageCate.map((color)-> MapEntityToDTO.mapColorToColorDTO(color));
    }

    @Override
    public Color findById(int id) {
        return this.colorRepo.findById(id).orElse(null);
    }

    @Override
    public Color findByName(String name) {
        return this.colorRepo.findByName(name);
    }

    @Override
    public Color save(Color color) {
        LocalDateTime now = LocalDateTime.now();
        color.setCreateAt(now);
        color.setUpdateAt(now);
        color.setStatus(1);
        return this.colorRepo.save(color);
    }

    @Override
    public Color update( Color color) {
        color.setUpdateAt(LocalDateTime.now());
        return this.colorRepo.save(color);
    }

    @Override
    public void delete(Color category) {

    }
}
