package com.example.h6.service;

import com.example.h6.entity.DangKy;
import com.example.h6.repository.DangKyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DangKyService {
    @Autowired
    private DangKyRepository DangKyRepository;

    public List<DangKy> getAll() {
        Iterable<DangKy> DangKyIterable = DangKyRepository.findAll();
        List<DangKy> DangKyList = new ArrayList<>();

        DangKyIterable.forEach(DangKyList::add);

        return DangKyList;
    }

    public Optional<DangKy> getById(Long id) {
        Optional<DangKy> DangKy = DangKyRepository.findById(id);
        return DangKy;
    }
    public DangKy save(DangKy DangKy) {
        return DangKyRepository.save(DangKy);
    }

    public DangKy update(DangKy DangKy) {
        return DangKyRepository.save(DangKy);
    }

    public ResponseEntity<Object> delete(Long id) {
        Optional<DangKy> DangKyOptional = DangKyRepository.findById(id);
        if (!DangKyOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(DangKyOptional);
        }
        DangKyRepository.delete(DangKyOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(DangKyOptional);
    }
}
