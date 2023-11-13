package com.example.h6.api;

import com.example.h6.dto.LichHocDto;
import com.example.h6.dto.LopHocPhanDto;
import com.example.h6.entity.*;
import com.example.h6.service.ChiNhanhService;
import com.example.h6.service.ChuyenNganhService;
import com.example.h6.service.LopHocPhanService;
import com.example.h6.service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin

@RequestMapping("/api/lop-hoc-phan")
public class LopHocPhanApi {

    @Autowired
    private LopHocPhanService LopHocPhanService;
    @Autowired
    private ChiNhanhService chiNhanhService;
    @Autowired
    private MonHocService monHocService;

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<LopHocPhan>> getAll() {
        List<LopHocPhan> LopHocPhanList = LopHocPhanService.getAll();
        if(LopHocPhanList.isEmpty()) {
            LopHocPhanList = new ArrayList<>();
        }
        return ResponseEntity.ok(LopHocPhanList);
    }

    @PostMapping(value = "/get-by-id")
    public ResponseEntity<LopHocPhan> getById(@RequestBody LopHocPhanDto lopHocPhanDto) {
        Optional<LopHocPhan> lopHocPhanOptional = LopHocPhanService.getById(lopHocPhanDto.getId());

        return ResponseEntity.ok(lopHocPhanOptional.orElse(null));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<LopHocPhan> create(@RequestBody LopHocPhanDto LopHocPhanDto) {
        Optional<MonHoc> monHocOptional = monHocService.getById(LopHocPhanDto.getIdMonHoc());
        Optional<ChiNhanh> chiNhanhOptional = chiNhanhService.getById(LopHocPhanDto.getIdChiNhanh());

        LopHocPhan LopHocPhan = new LopHocPhan();
        LopHocPhan.setHocKy(LopHocPhanDto.getHocKy());
        LopHocPhan.setNamHoc(LopHocPhanDto.getNamHoc());
        LopHocPhan.setSvToiDa(LopHocPhanDto.getSvToiDa());

        LopHocPhan.setMonHoc(monHocOptional.orElse(null));
        LopHocPhan.setChiNhanh(chiNhanhOptional.orElse(null));

        LopHocPhan _LopHocPhan = LopHocPhanService.save(LopHocPhan);
        return ResponseEntity.ok(LopHocPhan);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<LopHocPhan> update(@RequestBody LopHocPhanDto LopHocPhanDto) {
        Optional<MonHoc> monHocOptional = monHocService.getById(LopHocPhanDto.getIdMonHoc());
        Optional<ChiNhanh> chiNhanhOptional = chiNhanhService.getById(LopHocPhanDto.getIdChiNhanh());

        LopHocPhan LopHocPhan = new LopHocPhan();
        LopHocPhan.setId(LopHocPhanDto.getId());
        LopHocPhan.setHocKy(LopHocPhanDto.getHocKy());
        LopHocPhan.setNamHoc(LopHocPhanDto.getNamHoc());
        LopHocPhan.setSvToiDa(LopHocPhanDto.getSvToiDa());

        LopHocPhan.setMonHoc(monHocOptional.orElse(null));
        LopHocPhan.setChiNhanh(chiNhanhOptional.orElse(null));

        LopHocPhan _LopHocPhan = LopHocPhanService.update(LopHocPhan);
        return ResponseEntity.ok(LopHocPhan);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Object> delete(@RequestBody LopHocPhanDto LopHocPhanDto) {
        return LopHocPhanService.delete(LopHocPhanDto.getId());
    }
}
