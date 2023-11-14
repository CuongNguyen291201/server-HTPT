package com.example.h6.repository;

import com.example.h6.entity.GiangVien;
import com.example.h6.entity.QuanLy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuanLyRepository extends CrudRepository<QuanLy, Long> {
}
