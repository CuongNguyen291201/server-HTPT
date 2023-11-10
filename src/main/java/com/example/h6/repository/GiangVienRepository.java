package com.example.h6.repository;

import com.example.h6.entity.ChuyenNganh;
import com.example.h6.entity.GiangVien;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiangVienRepository extends CrudRepository<GiangVien, Long> {
}
