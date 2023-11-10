package com.example.h6.service;

import com.example.h6.entity.SinhVien;
import com.example.h6.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SinhVienService {
    @Autowired
    private SinhVienRepository SinhVienRepository;

    public List<SinhVien> getAll() {
        Iterable<SinhVien> SinhVienIterable = SinhVienRepository.findAll();
        List<SinhVien> SinhVienList = new ArrayList<>();

        SinhVienIterable.forEach(SinhVienList::add);

        return SinhVienList;
    }

    public Optional<SinhVien> getById(Long id) {
        Optional<SinhVien> SinhVien = SinhVienRepository.findById(id);
        return SinhVien;
    }
    public SinhVien save(SinhVien SinhVien) {
        return SinhVienRepository.save(SinhVien);
    }

    public SinhVien update(SinhVien SinhVien) {
        SinhVienRepository.deleteById(SinhVien.getId());
        return SinhVienRepository.save(SinhVien);
    }

    public ResponseEntity<Object> delete(Long id) {
        Optional<SinhVien> SinhVienOptional = SinhVienRepository.findById(id);
        if (!SinhVienOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(SinhVienOptional);
        }
        SinhVienRepository.delete(SinhVienOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(SinhVienOptional);
    }
}
