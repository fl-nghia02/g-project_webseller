package com.webseller.be.controller.admin;

import com.webseller.be.dto.DesignDTO;
import com.webseller.be.dto.MapToDTO.MapEntityToDTO;
import com.webseller.be.entity.Design;
import com.webseller.be.service.IDesignService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/admin/design")
public class DesignController {
    @Autowired
    private IDesignService DesignService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<?> getAllDesign(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "20") int size) throws InterruptedException {
//        Thread.sleep(2000);
        Pageable pageable = PageRequest.of(page, size);
        Page<DesignDTO> DesignDTOPage = this.DesignService.findAllWithPage(pageable);
        return ResponseEntity.ok(DesignDTOPage);
    }

    @PostMapping("create")
    public ResponseEntity<?> createDesign(@RequestBody DesignDTO DesignDTO) {
        if (DesignDTO.getName().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tên kiểu dáng không được để trống");
        }
        if (this.DesignService.findByName(DesignDTO.getName()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Đã tồn tại kiểu dáng ");
        }
        Design Design = modelMapper.map(DesignDTO, Design.class);
        Design = this.DesignService.save(Design);
        DesignDTO newDesignDTO = MapEntityToDTO.mapDesignToDesignDTO(Design);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDesignDTO);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateDesign(@PathVariable int id, @RequestBody DesignDTO DesignDTO) {
        Design oldDesign = this.DesignService.findById(id);
        if (DesignDTO.getName().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tên kiểu dáng không được để trống");
        }
        if (this.DesignService.findByName(DesignDTO.getName()) != null
                && !oldDesign.getName().equals(DesignDTO.getName())
        ) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Đã tồn tại kiểu dáng");
        }

        oldDesign.setName(DesignDTO.getName());
        oldDesign.setStatus(DesignDTO.getStatus());
        oldDesign.setUpdateBy(DesignDTO.getUpdateBy());

        Design newDesign = this.DesignService.update(oldDesign);
        DesignDTO newCategoryDTO = MapEntityToDTO.mapDesignToDesignDTO(newDesign);
        return ResponseEntity.status(HttpStatus.OK).body(newCategoryDTO);
    }
}
