package com.example.h6.service;

import com.example.h6.entity.MonHoc;
import com.example.h6.repository.MonHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MonHocService {
    @Autowired
    private MonHocRepository MonHocRepository;

    public List<MonHoc> getAll() {
        Iterable<MonHoc> MonHocIterable = MonHocRepository.findAll();
        List<MonHoc> MonHocList = new ArrayList<>();

        MonHocIterable.forEach(MonHocList::add);

        return MonHocList;
    }

    public Optional<MonHoc> getById(Long id) {
        Optional<MonHoc> MonHoc = MonHocRepository.findById(id);
        return MonHoc;
    }
    public MonHoc save(MonHoc MonHoc) {
        return MonHocRepository.save(MonHoc);
    }

    public MonHoc update(MonHoc MonHoc) {
        return MonHocRepository.save(MonHoc);
    }

    public ResponseEntity<Object> delete(Long id) {
        Optional<MonHoc> MonHocOptional = MonHocRepository.findById(id);
        if (!MonHocOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(MonHocOptional);
        }
        MonHocRepository.delete(MonHocOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(MonHocOptional);
    }
}
