package com.example.h6.repository;

import com.example.h6.entity.LichHoc;
import com.example.h6.entity.LopHocPhan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LichHocRepository extends CrudRepository<LichHoc, Long> {
}
