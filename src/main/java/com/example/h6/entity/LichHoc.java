package com.example.h6.entity;

import jakarta.persistence.*;

@Table
@Entity(name = "LichHoc")
public class LichHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10)
    private Long id;

    @Column(name = "thu", length = 10)
    private int thu;
    @Column(name = "kip", length = 10)
    private int kip;

    @Column(name = "phong", length = 255)
    private String phong;

    @ManyToOne
    @JoinColumn(name = "maGiangVien")
    private GiangVien giangVien;

    @ManyToOne
    @JoinColumn(name = "maLopHocPhan")
    private LopHocPhan lopHocPhan;

    public LichHoc() {

    }

    public LichHoc(Long id, int thu, int kip, String phong) {
        this.id = id;
        this.thu = thu;
        this.kip = kip;
        this.phong = phong;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getThu() {
        return thu;
    }

    public void setThu(int thu) {
        this.thu = thu;
    }

    public int getKip() {
        return kip;
    }

    public void setKip(int kip) {
        this.kip = kip;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    public LopHocPhan getLopHocPhan() {
        return lopHocPhan;
    }

    public void setLopHocPhan(LopHocPhan lopHocPhan) {
        this.lopHocPhan = lopHocPhan;
    }
}
