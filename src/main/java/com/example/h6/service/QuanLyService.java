package com.example.h6.service;

import com.example.h6.entity.QuanLy;
import com.example.h6.repository.QuanLyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuanLyService {
    @Autowired
    private QuanLyRepository QuanLyRepository;

    public List<QuanLy> getAll() {
        Iterable<QuanLy> QuanLyIterable = QuanLyRepository.findAll();
        List<QuanLy> QuanLyList = new ArrayList<>();

        QuanLyIterable.forEach(QuanLyList::add);

        return QuanLyList;
    }

    public Optional<QuanLy> getById(Long id) {
        Optional<QuanLy> QuanLy = QuanLyRepository.findById(id);
        return QuanLy;
    }
    public QuanLy save(QuanLy QuanLy) {
        return QuanLyRepository.save(QuanLy);
    }

    public QuanLy update(QuanLy QuanLy) {
        QuanLyRepository.deleteById(QuanLy.getId());
        return QuanLyRepository.save(QuanLy);
    }

    public ResponseEntity<Object> delete(Long id) {
        Optional<QuanLy> QuanLyOptional = QuanLyRepository.findById(id);
        if (!QuanLyOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(QuanLyOptional);
        }
        QuanLyRepository.delete(QuanLyOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(QuanLyOptional);
    }
}
