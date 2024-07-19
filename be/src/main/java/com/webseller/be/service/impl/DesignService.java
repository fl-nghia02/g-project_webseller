package com.webseller.be.service.impl;

import com.webseller.be.dto.DesignDTO;
import com.webseller.be.dto.MapToDTO.MapEntityToDTO;
import com.webseller.be.entity.Design;
import com.webseller.be.repository.DesignRepo;
import com.webseller.be.service.IDesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DesignService implements IDesignService {

    @Autowired
    DesignRepo colorRepo;
    @Override
    public Page<DesignDTO> findAllWithPage(Pageable pageable) {
        Page<Design> pageCate = this.colorRepo.findAll(pageable);
        return pageCate.map((design)-> MapEntityToDTO.mapDesignToDesignDTO(design));
    }

    @Override
    public Design findById(int id) {
        return this.colorRepo.findById(id).orElse(null);
    }

    @Override
    public Design findByName(String name) {
        return this.colorRepo.findByName(name);
    }

    @Override
    public Design save(Design design) {
        LocalDateTime now = LocalDateTime.now();
        design.setCreateAt(now);
        design.setUpdateAt(now);
        design.setStatus(1);
        return this.colorRepo.save(design);
    }

    @Override
    public Design update( Design design) {
        design.setUpdateAt(LocalDateTime.now());
        return this.colorRepo.save(design);
    }

    @Override
    public void delete(Design category) {

    }
}
