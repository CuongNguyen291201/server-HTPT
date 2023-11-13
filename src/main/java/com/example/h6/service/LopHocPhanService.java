package com.example.h6.service;

import com.example.h6.entity.LopHocPhan;
import com.example.h6.repository.LopHocPhanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LopHocPhanService {
    @Autowired
    private LopHocPhanRepository LopHocPhanRepository;

    public List<LopHocPhan> getAll() {
        Iterable<LopHocPhan> LopHocPhanIterable = LopHocPhanRepository.findAll();
        List<LopHocPhan> LopHocPhanList = new ArrayList<>();

        LopHocPhanIterable.forEach(LopHocPhanList::add);

        return LopHocPhanList;
    }

    public Optional<LopHocPhan> getById(Long id) {
        Optional<LopHocPhan> LopHocPhan = LopHocPhanRepository.findById(id);
        return LopHocPhan;
    }
    public LopHocPhan save(LopHocPhan LopHocPhan) {
        return LopHocPhanRepository.save(LopHocPhan);
    }

    public LopHocPhan update(LopHocPhan LopHocPhan) {
        return LopHocPhanRepository.save(LopHocPhan);
    }

    public ResponseEntity<Object> delete(Long id) {
        Optional<LopHocPhan> LopHocPhanOptional = LopHocPhanRepository.findById(id);
        if (!LopHocPhanOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(LopHocPhanOptional);
        }
        LopHocPhanRepository.delete(LopHocPhanOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(LopHocPhanOptional);
    }
}
