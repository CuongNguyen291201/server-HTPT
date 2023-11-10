package com.example.h6.service;

import com.example.h6.entity.ChiNhanh;
import com.example.h6.repository.ChiNhanhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChiNhanhService {
    @Autowired
    private ChiNhanhRepository ChiNhanhRepository;

    public List<ChiNhanh> getAll() {
        Iterable<ChiNhanh> ChiNhanhIterable = ChiNhanhRepository.findAll();
        List<ChiNhanh> ChiNhanhList = new ArrayList<>();

        ChiNhanhIterable.forEach(ChiNhanhList::add);

        return ChiNhanhList;
    }

    public Optional<ChiNhanh> getById(Long id) {
        Optional<ChiNhanh> chiNhanh = ChiNhanhRepository.findById(id);
        return chiNhanh;
    }
    public ChiNhanh save(ChiNhanh ChiNhanh) {
        return ChiNhanhRepository.save(ChiNhanh);
    }

    public ChiNhanh update(ChiNhanh ChiNhanh) {
        return ChiNhanhRepository.save(ChiNhanh);
    }

    public ResponseEntity<Object> delete(Long id) {
        Optional<ChiNhanh> ChiNhanhOptional = ChiNhanhRepository.findById(id);
        if (!ChiNhanhOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ChiNhanhOptional);
        }
        ChiNhanhRepository.delete(ChiNhanhOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(ChiNhanhOptional);
    }
}
