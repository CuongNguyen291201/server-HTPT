package com.example.h6.entity;

import jakarta.persistence.*;

import java.util.List;

@Table
@Entity(name = "ChuyenNganh")
public class ChuyenNganh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10)
    private Long id;

    @Column(name = "ten", length = 255)
    private String ten;

    @OneToMany(mappedBy = "chuyenNganh", cascade = CascadeType.ALL)
    private List<MonHoc> monHoc;

    @OneToMany(mappedBy = "chuyenNganh", cascade = CascadeType.ALL)
    private List<SinhVien> sinhVien;


    public ChuyenNganh() {

    }

    public ChuyenNganh(int id) {

    }

    public ChuyenNganh(String ten) {

    }

    public ChuyenNganh(Long id, String ten) {
        this.id = id;
        this.ten = ten;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
