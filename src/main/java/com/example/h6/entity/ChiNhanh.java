package com.example.h6.entity;

import jakarta.persistence.*;

import java.util.List;

@Table
@Entity(name = "ChiNhanh")
public class ChiNhanh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ten")
    private String ten;

    @OneToMany(mappedBy = "chiNhanh", cascade = CascadeType.ALL)
    private List<QuanLy> quanLy;

    @OneToMany(mappedBy = "chiNhanh", cascade = CascadeType.ALL)
    private List<GiangVien> giangVien;

    @OneToMany(mappedBy = "chiNhanh", cascade = CascadeType.ALL)
    private List<SinhVien> sinhVien;

    @OneToMany(mappedBy = "chiNhanh", cascade = CascadeType.ALL)
    private List<LopHocPhan> lopHocPhan;

    public ChiNhanh() {

    }

    public ChiNhanh(int id) {

    }

    public ChiNhanh(Long id, String ten) {
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
