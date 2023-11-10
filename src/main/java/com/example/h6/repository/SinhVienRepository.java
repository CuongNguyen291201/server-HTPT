package com.example.h6.repository;

import com.example.h6.entity.GiangVien;
import com.example.h6.entity.SinhVien;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinhVienRepository extends CrudRepository<SinhVien, Long> {
}
