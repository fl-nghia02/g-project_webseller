package com.webseller.be.service.impl;

import com.webseller.be.dto.SizeDTO;
import com.webseller.be.dto.MapToDTO.MapEntityToDTO;
import com.webseller.be.entity.Size;
import com.webseller.be.repository.SizeRepo;
import com.webseller.be.service.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SizeService implements ISizeService {
    @Autowired
    SizeRepo sizeRepo;
    @Override
    public Page<SizeDTO> findAllWithPage(Pageable pageable) {
        Page<Size> pageCate = this.sizeRepo.findAll(pageable);
        return pageCate.map((size)-> MapEntityToDTO.mapSizeToSizeDTO(size));
    }

    @Override
    public Size findById(int id) {
        return this.sizeRepo.findById(id).orElse(null);
    }

    @Override
    public Size findByName(String name) {
        return this.sizeRepo.findByName(name);
    }

    @Override
    public Size save(Size size) {
        LocalDateTime now = LocalDateTime.now();
        size.setCreateAt(now);
        size.setUpdateAt(now);
        size.setStatus(1);
        return this.sizeRepo.save(size);
    }

    @Override
    public Size update( Size size) {
        size.setUpdateAt(LocalDateTime.now());
        return this.sizeRepo.save(size);
    }

    @Override
    public void delete(Size category) {

    }
}
