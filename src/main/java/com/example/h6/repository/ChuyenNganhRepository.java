package com.example.h6.repository;

import com.example.h6.entity.ChuyenNganh;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChuyenNganhRepository extends CrudRepository<ChuyenNganh, Long> {
}
