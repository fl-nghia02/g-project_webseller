package com.webseller.be.controller.admin;

import com.webseller.be.dto.ColorDTO;
import com.webseller.be.dto.MapToDTO.MapEntityToDTO;
import com.webseller.be.entity.Color;
import com.webseller.be.service.IColorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin/color")
public class ColorController {
    @Autowired
    private IColorService colorService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<?> getAllColor(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "20") int size) throws InterruptedException {
//        Thread.sleep(2000);
        Pageable pageable = PageRequest.of(page, size);
        Page<ColorDTO> colorDTOPage = this.colorService.findAllWithPage(pageable);
        return ResponseEntity.ok(colorDTOPage);
    }

    @PostMapping("create")
    public ResponseEntity<?> createColor(@RequestBody ColorDTO colorDTO) {
        if (colorDTO.getName().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tên màu sắc không được để trống");
        }
        if (this.colorService.findByName(colorDTO.getName()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Đã tồn tại màu sắc ");
        }
        Color color = modelMapper.map(colorDTO, Color.class);
        color = this.colorService.save(color);
        ColorDTO newColorDTO = MapEntityToDTO.mapColorToColorDTO(color);
        return ResponseEntity.status(HttpStatus.CREATED).body(newColorDTO);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateColor(@PathVariable int id, @RequestBody ColorDTO colorDTO) {
        Color oldColor = this.colorService.findById(id);
        if (colorDTO.getName().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tên màu sắc không được để trống");
        }
        if (this.colorService.findByName(colorDTO.getName()) != null
                && !oldColor.getName().equals(colorDTO.getName())
        ) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Đã tồn tại màu sắc");
        }

        oldColor.setName(colorDTO.getName());
        oldColor.setStatus(colorDTO.getStatus());
        oldColor.setUpdateBy(colorDTO.getUpdateBy());

        Color newColor = this.colorService.update(oldColor);
        ColorDTO newCategoryDTO = MapEntityToDTO.mapColorToColorDTO(newColor);
        return ResponseEntity.status(HttpStatus.OK).body(newCategoryDTO);
    }
}
