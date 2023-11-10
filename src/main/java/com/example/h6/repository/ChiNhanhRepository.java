package com.example.h6.repository;

import com.example.h6.entity.ChiNhanh;
import com.example.h6.entity.ChuyenNganh;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiNhanhRepository extends CrudRepository<ChiNhanh, Long> {
}
