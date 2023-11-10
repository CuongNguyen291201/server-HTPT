package com.example.h6.api;

import com.example.h6.dto.ChuyenNganhDto;
import com.example.h6.entity.ChuyenNganh;
import com.example.h6.service.ChuyenNganhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/chuyen-nganh")
public class ChuyenNganhApi {

    @Autowired
    private ChuyenNganhService chuyenNganhService;

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<ChuyenNganh>> getAll() {
        List<ChuyenNganh> chuyenNganhList = chuyenNganhService.getAll();
        if (chuyenNganhList.isEmpty()) {
            chuyenNganhList = new ArrayList<>();
        }
        return ResponseEntity.ok(chuyenNganhList);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<ChuyenNganh> create(@RequestBody ChuyenNganhDto chuyenNganhDto) {
        ChuyenNganh chuyenNganh = new ChuyenNganh();
        chuyenNganh.setTen(chuyenNganhDto.getTen());

        ChuyenNganh _chuyenNganh = chuyenNganhService.save(chuyenNganh);
        return ResponseEntity.ok(_chuyenNganh);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<ChuyenNganh> update(@RequestBody ChuyenNganhDto chuyenNganhDto) {
        ChuyenNganh chuyenNganh = new ChuyenNganh();
        chuyenNganh.setId(chuyenNganhDto.getId());
        chuyenNganh.setTen(chuyenNganhDto.getTen());

        ChuyenNganh _chuyenNganh = chuyenNganhService.update(chuyenNganh);
        return ResponseEntity.ok(_chuyenNganh);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Object> delete(@RequestBody ChuyenNganhDto chuyenNganhDto) {
        return chuyenNganhService.delete(chuyenNganhDto.getId());
    }
}
