package com.example.h6.repository;

import com.example.h6.entity.DangKy;
import com.example.h6.entity.LichHoc;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DangKyRepository extends CrudRepository<DangKy, Long> {
}
