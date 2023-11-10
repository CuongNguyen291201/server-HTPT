package com.example.h6.service;

import com.example.h6.entity.ChiNhanh;
import com.example.h6.entity.ChuyenNganh;
import com.example.h6.repository.ChuyenNganhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ChuyenNganhService {
    @Autowired
    private ChuyenNganhRepository chuyenNganhRepository;

    public List<ChuyenNganh> getAll() {
        Iterable<ChuyenNganh> chuyenNganhIterable = chuyenNganhRepository.findAll();
        List<ChuyenNganh> chuyenNganhList = new ArrayList<>();

        chuyenNganhIterable.forEach(chuyenNganhList::add);

        return  chuyenNganhList;
    }

    public Optional<ChuyenNganh> getById(Long id) {
        Optional<ChuyenNganh> chuyenNganh = chuyenNganhRepository.findById(id);
        return chuyenNganh;
    }

    public ChuyenNganh save(ChuyenNganh chuyenNganh) {
        return chuyenNganhRepository.save(chuyenNganh);
    }

    public ChuyenNganh update(ChuyenNganh chuyenNganh) {
        return chuyenNganhRepository.save(chuyenNganh);
    }

    public ResponseEntity<Object> delete(Long id) {
        Optional<ChuyenNganh> chuyenNganhOptional = chuyenNganhRepository.findById(id);
        if (!chuyenNganhOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(chuyenNganhOptional);
        }
        chuyenNganhRepository.delete(chuyenNganhOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(chuyenNganhOptional);
    }
}
