package com.webseller.be.controller.admin;

import com.webseller.be.dto.SizeDTO;
import com.webseller.be.dto.MapToDTO.MapEntityToDTO;
import com.webseller.be.entity.Size;
import com.webseller.be.service.IProductService;
import com.webseller.be.service.ISizeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/admin/size")
public class SizeController {
    @Autowired
    private ISizeService sizeService;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<?> getAllSize(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "20") int size) throws InterruptedException {
//        Thread.sleep(2000);
        Pageable pageable = PageRequest.of(page, size);
        Page<SizeDTO> sizeDTOPage = this.sizeService.findAllWithPage(pageable);
        return ResponseEntity.ok(sizeDTOPage);
    }

    @PostMapping("create")
    public ResponseEntity<?> createSize(@RequestBody SizeDTO sizeDTO) {
        if (sizeDTO.getName().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tên size không được để trống");
        }
        if (this.sizeService.findByName(sizeDTO.getName()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Đã tồn tại size ");
        }
        Size size = modelMapper.map(sizeDTO, Size.class);
        size = this.sizeService.save(size);
        SizeDTO newSizeDTO = MapEntityToDTO.mapSizeToSizeDTO(size);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSizeDTO);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateSize(@PathVariable int id, @RequestBody SizeDTO sizeDTO) {
        Size oldSize = this.sizeService.findById(id);
        if (sizeDTO.getName().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tên size không được để trống");
        }
        if (this.sizeService.findByName(sizeDTO.getName()) != null
                && !oldSize.getName().equals(sizeDTO.getName())
        ) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Đã tồn tại size");
        }

        oldSize.setName(sizeDTO.getName());
        oldSize.setStatus(sizeDTO.getStatus());
        oldSize.setUpdateBy(sizeDTO.getUpdateBy());

        Size newSize = this.sizeService.update(oldSize);
        SizeDTO newCategoryDTO = MapEntityToDTO.mapSizeToSizeDTO(newSize);
        return ResponseEntity.status(HttpStatus.OK).body(newCategoryDTO);
    }
}
