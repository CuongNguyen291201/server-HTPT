package com.example.h6.service;

import com.example.h6.entity.GiangVien;
import com.example.h6.repository.GiangVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GiangVienService {
    @Autowired
    private GiangVienRepository GiangVienRepository;

    public List<GiangVien> getAll() {
        Iterable<GiangVien> GiangVienIterable = GiangVienRepository.findAll();
        List<GiangVien> GiangVienList = new ArrayList<>();

        GiangVienIterable.forEach(GiangVienList::add);

        return GiangVienList;
    }

    public Optional<GiangVien> getById(Long id) {
        Optional<GiangVien> GiangVien = GiangVienRepository.findById(id);
        return GiangVien;
    }
    public GiangVien save(GiangVien GiangVien) {
        return GiangVienRepository.save(GiangVien);
    }

    public GiangVien update(GiangVien GiangVien) {
        GiangVienRepository.deleteById(GiangVien.getId());
        return GiangVienRepository.save(GiangVien);
    }

    public ResponseEntity<Object> delete(Long id) {
        Optional<GiangVien> GiangVienOptional = GiangVienRepository.findById(id);
        if (!GiangVienOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(GiangVienOptional);
        }
        GiangVienRepository.delete(GiangVienOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(GiangVienOptional);
    }
}
