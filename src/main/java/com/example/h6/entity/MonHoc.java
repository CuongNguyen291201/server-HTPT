package com.example.h6.entity;

import jakarta.persistence.*;

import java.util.List;

@Table
@Entity(name = "MonHoc")
public class MonHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10)
    private Long id;

    @Column(name = "ten", length = 255)
    private String ten;

    @Column(name = "soTc", length = 10)
    private int soTc;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maChuyenNganh")
    private ChuyenNganh chuyenNganh;

    @OneToMany(mappedBy = "monHoc", cascade = CascadeType.ALL)
    private List<LopHocPhan> lopHocPhan;

    public MonHoc() {

    }

    public MonHoc(int id) {

    }

    public MonHoc(Long id, String ten, int soTc, ChuyenNganh chuyenNganh) {
        this.id = id;
        this.ten = ten;
        this.soTc = soTc;
        this.chuyenNganh = chuyenNganh;
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

    public int getSoTc() {
        return soTc;
    }

    public void setSoTc(int soTc) {
        this.soTc = soTc;
    }

    public ChuyenNganh getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(ChuyenNganh chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }
}
