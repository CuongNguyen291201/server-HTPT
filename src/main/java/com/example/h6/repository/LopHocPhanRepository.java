package com.example.h6.repository;

import com.example.h6.entity.LopHocPhan;
import com.example.h6.entity.MonHoc;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LopHocPhanRepository extends CrudRepository<LopHocPhan, Long> {
}
