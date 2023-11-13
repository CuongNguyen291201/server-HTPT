package com.example.h6.api;

import com.example.h6.dto.ChiNhanhDto;
import com.example.h6.entity.ChiNhanh;
import com.example.h6.service.ChiNhanhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/chi-nhanh")
public class ChiNhanhApi {

    @Autowired
    private ChiNhanhService ChiNhanhService;

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<ChiNhanh>> getAll() {
        List<ChiNhanh> ChiNhanhList = ChiNhanhService.getAll();
        if(ChiNhanhList.isEmpty()) {
            ChiNhanhList = new ArrayList<>();
        }
        return ResponseEntity.ok(ChiNhanhList);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<ChiNhanh> create(@RequestBody ChiNhanhDto ChiNhanhDto) {
        ChiNhanh ChiNhanh = new ChiNhanh();
        ChiNhanh.setTen(ChiNhanhDto.getTen());

        ChiNhanh _ChiNhanh = ChiNhanhService.save(ChiNhanh);
        return ResponseEntity.ok(ChiNhanh);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<ChiNhanh> update(@RequestBody ChiNhanhDto ChiNhanhDto) {
        ChiNhanh ChiNhanh = new ChiNhanh();
        ChiNhanh.setId(ChiNhanhDto.getId());
        ChiNhanh.setTen(ChiNhanhDto.getTen());

        ChiNhanh _ChiNhanh = ChiNhanhService.update(ChiNhanh);
        return ResponseEntity.ok(ChiNhanh);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Object> delete(@RequestBody ChiNhanhDto ChiNhanhDto) {
        return ChiNhanhService.delete(ChiNhanhDto.getId());
    }
}
