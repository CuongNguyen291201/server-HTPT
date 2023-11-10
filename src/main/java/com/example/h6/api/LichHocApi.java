package com.example.h6.api;

import com.example.h6.dto.LichHocDto;
import com.example.h6.entity.*;
import com.example.h6.service.ChiNhanhService;
import com.example.h6.service.GiangVienService;
import com.example.h6.service.LichHocService;
import com.example.h6.service.LopHocPhanService;
import com.example.h6.service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lich-hoc")
public class LichHocApi {
    @Autowired
    private LichHocService LichHocService;
    @Autowired
    private LopHocPhanService lopHocPhanService;
    @Autowired
    private GiangVienService giangVienService;

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<LichHoc>> getAll() {
        List<LichHoc> LichHocList = LichHocService.getAll();
        if(LichHocList.isEmpty()) {
            LichHocList = new ArrayList<>();
        }
        return ResponseEntity.ok(LichHocList);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<LichHoc> create(@RequestBody LichHocDto LichHocDto) {
        Optional<LopHocPhan> lopHocPhanOptional = lopHocPhanService.getById(LichHocDto.getIdLopHocPhan());
        Optional<GiangVien> giangVienOptional = giangVienService.getById(LichHocDto.getIdGiangVien());

        LichHoc LichHoc = new LichHoc();
        LichHoc.setKip(LichHoc.getKip());
        LichHoc.setThu(LichHoc.getThu());
        LichHoc.setPhong(LichHoc.getPhong());

        LichHoc.setLopHocPhan(lopHocPhanOptional.orElse(null));
        LichHoc.setGiangVien(giangVienOptional.orElse(null));

        LichHoc _LichHoc = LichHocService.save(LichHoc);
        return ResponseEntity.ok(LichHoc);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<LichHoc> update(@RequestBody LichHocDto LichHocDto) {
        Optional<LopHocPhan> lopHocPhanOptional = lopHocPhanService.getById(LichHocDto.getIdLopHocPhan());
        Optional<GiangVien> giangVienOptional = giangVienService.getById(LichHocDto.getIdGiangVien());

        LichHoc LichHoc = new LichHoc();
        LichHoc.setId(LichHocDto.getId());
        LichHoc.setKip(LichHoc.getKip());
        LichHoc.setThu(LichHoc.getThu());
        LichHoc.setPhong(LichHoc.getPhong());

        LichHoc.setLopHocPhan(lopHocPhanOptional.orElse(null));
        LichHoc.setGiangVien(giangVienOptional.orElse(null));

        LichHoc _LichHoc = LichHocService.update(LichHoc);
        return ResponseEntity.ok(LichHoc);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Object> delete(@RequestBody LichHocDto LichHocDto) {
        return LichHocService.delete(LichHocDto.getId());
    }
}
