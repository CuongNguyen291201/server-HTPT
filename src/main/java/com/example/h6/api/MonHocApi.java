package com.example.h6.api;

import com.example.h6.dto.LichHocDto;
import com.example.h6.dto.MonHocDto;
import com.example.h6.entity.ChiNhanh;
import com.example.h6.entity.ChuyenNganh;
import com.example.h6.entity.LichHoc;
import com.example.h6.entity.MonHoc;
import com.example.h6.service.ChuyenNganhService;
import com.example.h6.service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin

@RequestMapping("/api/mon-hoc")
public class MonHocApi {

    @Autowired
    private MonHocService MonHocService;
    @Autowired
    private ChuyenNganhService chuyenNganhService;

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<MonHoc>> getAll() {
        List<MonHoc> MonHocList = MonHocService.getAll();
        if(MonHocList.isEmpty()) {
            MonHocList = new ArrayList<>();
        }
        return ResponseEntity.ok(MonHocList);
    }

    @PostMapping(value = "/get-by-id")
    public ResponseEntity<MonHoc> getById(@RequestBody MonHocDto monHocDto) {
        Optional<MonHoc> monHocOptional = MonHocService.getById(monHocDto.getId());

        return ResponseEntity.ok(monHocOptional.orElse(null));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<MonHoc> create(@RequestBody MonHocDto MonHocDto) {
        Optional<ChuyenNganh> chuyenNganhOptional = chuyenNganhService.getById(MonHocDto.getIdChuyenNganh());

        System.out.println(MonHocDto);

        MonHoc MonHoc = new MonHoc();
        MonHoc.setTen(MonHocDto.getTen());
        MonHoc.setSoTc(MonHocDto.getSoTc());
        MonHoc.setChuyenNganh(chuyenNganhOptional.orElse(null));

        MonHoc _MonHoc = MonHocService.save(MonHoc);
        return ResponseEntity.ok(MonHoc);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<MonHoc> update(@RequestBody MonHocDto MonHocDto) {
        Optional<ChuyenNganh> chuyenNganhOptional = chuyenNganhService.getById(MonHocDto.getIdChuyenNganh());

        MonHoc MonHoc = new MonHoc();
        MonHoc.setId(MonHocDto.getId());
        MonHoc.setTen(MonHocDto.getTen());
        MonHoc.setSoTc(MonHocDto.getSoTc());
        MonHoc.setChuyenNganh(chuyenNganhOptional.orElse(null));

        MonHoc _MonHoc = MonHocService.update(MonHoc);
        return ResponseEntity.ok(MonHoc);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Object> delete(@RequestBody MonHocDto MonHocDto) {
        return MonHocService.delete(MonHocDto.getId());
    }
}
