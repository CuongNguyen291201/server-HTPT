package com.example.h6.api;

import com.example.h6.dto.ChuyenNganhDto;
import com.example.h6.dto.DangKyDto;
import com.example.h6.entity.*;
import com.example.h6.service.GiangVienService;
import com.example.h6.service.DangKyService;
import com.example.h6.service.LopHocPhanService;
import com.example.h6.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/dang-ky")
public class DangKyApi {

    @Autowired
    private DangKyService DangKyService;
    @Autowired
    private LopHocPhanService lopHocPhanService;
    @Autowired
    private SinhVienService sinhVienService;

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<DangKy>> getAll() {
        List<DangKy> DangKyList = DangKyService.getAll();
        if(DangKyList.isEmpty()) {
            DangKyList = new ArrayList<>();
        }
        return ResponseEntity.ok(DangKyList);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<DangKy> create(@RequestBody DangKyDto DangKyDto) {
        Optional<LopHocPhan> lopHocPhanOptional = lopHocPhanService.getById(DangKyDto.getIdLopHocPhan());
        Optional<SinhVien> sinhVienOptional = sinhVienService.getById(DangKyDto.getIdSinhVien());

        DangKy DangKy = new DangKy();

        DangKy.setLopHocPhan(lopHocPhanOptional.orElse(null));
        DangKy.setSinhVien(sinhVienOptional.orElse(null));

        DangKy _DangKy = DangKyService.save(DangKy);
        return ResponseEntity.ok(DangKy);
    }

    @PostMapping(value = "/get-by-id")
    public ResponseEntity<DangKy> getById(@RequestBody DangKyDto dangKyDto) {
        Optional<DangKy> dangKyOptional = DangKyService.getById(dangKyDto.getId());

        return ResponseEntity.ok(dangKyOptional.orElse(null));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<DangKy> update(@RequestBody DangKyDto DangKyDto) {
        Optional<LopHocPhan> lopHocPhanOptional = lopHocPhanService.getById(DangKyDto.getIdLopHocPhan());
        Optional<SinhVien> sinhVienOptional = sinhVienService.getById(DangKyDto.getIdSinhVien());


        DangKy DangKy = new DangKy();
        DangKy.setId(DangKyDto.getId());

        DangKy.setLopHocPhan(lopHocPhanOptional.orElse(null));
        DangKy.setSinhVien(sinhVienOptional.orElse(null));

        DangKy _DangKy = DangKyService.update(DangKy);
        return ResponseEntity.ok(DangKy);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Object> delete(@RequestBody DangKyDto DangKyDto) {
        return DangKyService.delete(DangKyDto.getId());
    }
}
