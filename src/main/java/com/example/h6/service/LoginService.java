package com.example.h6.service;

import com.example.h6.entity.ChuyenNganh;
import com.example.h6.entity.GiangVien;
import com.example.h6.entity.QuanLy;
import com.example.h6.entity.SinhVien;
import com.example.h6.repository.ChuyenNganhRepository;
import com.example.h6.repository.GiangVienRepository;
import com.example.h6.repository.QuanLyRepository;
import com.example.h6.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private QuanLyRepository quanLyRepository;
    @Autowired
    private GiangVienRepository giangVienRepository;
    @Autowired
    private SinhVienRepository sinhVienRepository;

    public Object getCurrentUser(String email, String password) {
        Object currentUser = new Object();
        Boolean check = false;

        Iterable<QuanLy> quanLyIterable = quanLyRepository.findAll();
        Iterable<GiangVien> giangVienIterable = giangVienRepository.findAll();
        Iterable<SinhVien> sinhVienIterable = sinhVienRepository.findAll();

        List<QuanLy> quanLyList = new ArrayList<>();
        List<GiangVien> giangVienList = new ArrayList<>();
        List<SinhVien> sinhVienList = new ArrayList<>();

        quanLyIterable.forEach(quanLyList::add);
        giangVienIterable.forEach(giangVienList::add);
        sinhVienIterable.forEach(sinhVienList::add);

        for(QuanLy quanLy: quanLyList) {
            if (quanLy.getEmail().equals(email) && quanLy.getPassword().equals(password)) {
                currentUser = quanLy;
                check = true;
                break;
            }
        }

        if (!check) {
            for(GiangVien giangVien: giangVienList) {
                if (giangVien.getEmail().equals(email) && giangVien.getPassword().equals(password)) {
                    currentUser = giangVien;
                    check = true;
                    break;
                }
            }
        }

        if (!check) {
            for(SinhVien sinhVien: sinhVienList) {
                if (sinhVien.getEmail().equals(email) && sinhVien.getPassword().equals(password)) {
                    currentUser = sinhVien;
                    break;
                }
            }
        }


        return currentUser;
    }

//    public Optional<ChuyenNganh> getById(Long id) {
//        Optional<ChuyenNganh> chuyenNganh = chuyenNganhRepository.findById(id);
//        return chuyenNganh;
//    }

//    public ChuyenNganh save(ChuyenNganh chuyenNganh) {
//        return chuyenNganhRepository.save(chuyenNganh);
//    }
//
//    public ChuyenNganh update(ChuyenNganh chuyenNganh) {
//        return chuyenNganhRepository.save(chuyenNganh);
//    }
//
//    public ResponseEntity<Object> delete(Long id) {
//        Optional<ChuyenNganh> chuyenNganhOptional = chuyenNganhRepository.findById(id);
//        if (!chuyenNganhOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(chuyenNganhOptional);
//        }
//        chuyenNganhRepository.delete(chuyenNganhOptional.get());
//        return ResponseEntity.status(HttpStatus.OK).body(chuyenNganhOptional);
//    }
}
