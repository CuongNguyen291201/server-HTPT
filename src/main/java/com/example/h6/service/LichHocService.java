package com.example.h6.service;

import com.example.h6.entity.LichHoc;
import com.example.h6.repository.LichHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LichHocService {
    @Autowired
    private LichHocRepository LichHocRepository;

    public List<LichHoc> getAll() {
        Iterable<LichHoc> LichHocIterable = LichHocRepository.findAll();
        List<LichHoc> LichHocList = new ArrayList<>();

        LichHocIterable.forEach(LichHocList::add);

        return LichHocList;
    }

    public Optional<LichHoc> getById(Long id) {
        Optional<LichHoc> LichHoc = LichHocRepository.findById(id);
        return LichHoc;
    }
    public LichHoc save(LichHoc LichHoc) {
        return LichHocRepository.save(LichHoc);
    }

    public LichHoc update(LichHoc LichHoc) {
        return LichHocRepository.save(LichHoc);
    }

    public ResponseEntity<Object> delete(Long id) {
        Optional<LichHoc> LichHocOptional = LichHocRepository.findById(id);
        if (!LichHocOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(LichHocOptional);
        }
        LichHocRepository.delete(LichHocOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(LichHocOptional);
    }
}
