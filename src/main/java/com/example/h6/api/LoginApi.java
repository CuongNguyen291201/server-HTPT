package com.example.h6.api;

import com.example.h6.dto.ChuyenNganhDto;
import com.example.h6.dto.LoginDto;
import com.example.h6.entity.ChuyenNganh;
import com.example.h6.service.ChuyenNganhService;
import com.example.h6.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class LoginApi {

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/login")
    public ResponseEntity<Object> getById(@RequestBody LoginDto loginDto) {
        Object currentUser = loginService.getCurrentUser(loginDto.getEmail(), loginDto.getPassword());
        return ResponseEntity.ok(currentUser);
    }

//    @PostMapping(value = "/register")
//    public ResponseEntity<Object> create(@RequestBody LoginDto loginDto) {
//
//    }

//    @PutMapping(value = "/update")
//    public ResponseEntity<ChuyenNganh> update(@RequestBody ChuyenNganhDto chuyenNganhDto) {
//        ChuyenNganh chuyenNganh = new ChuyenNganh();
//        chuyenNganh.setId(chuyenNganhDto.getId());
//        chuyenNganh.setTen(chuyenNganhDto.getTen());
//
//        ChuyenNganh _chuyenNganh = chuyenNganhService.update(chuyenNganh);
//        return ResponseEntity.ok(_chuyenNganh);
//    }

//    @DeleteMapping(value = "/delete")
//    public ResponseEntity<Object> delete(@RequestBody ChuyenNganhDto chuyenNganhDto) {
//
//        System.out.println(chuyenNganhDto);
//
//        return chuyenNganhService.delete(chuyenNganhDto.getId());
//    }
}
