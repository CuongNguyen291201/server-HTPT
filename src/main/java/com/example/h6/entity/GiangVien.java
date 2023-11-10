package com.example.h6.entity;
import jakarta.persistence.*;

import java.util.List;

@Table
@Entity(name = "GiangVien")
public class GiangVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10)
    private Long id;

    @Column(name = "ten", length = 255)
    private String ten;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "password", length = 255)
    private String password;
    @Column(name = "ngaySinh", length = 255)
    private String ngaySinh;

    @Column(name = "gioiTinh", length = 255)
    private String gioiTinh;

    @Column(name = "luong", length = 255)
    private int luong;

    @ManyToOne
    @JoinColumn(name = "maChiNhanh")
    private ChiNhanh chiNhanh;

    @OneToMany(mappedBy = "giangVien", cascade = CascadeType.ALL)
    private List<LichHoc> lichHoc;

    public GiangVien() {

    }

    public GiangVien(int id) {

    }

    public GiangVien(Long id, String ten, String ngaySinh, String gioiTinh, int luong, String email, String password) {
        this.id = id;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.luong = luong;
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public ChiNhanh getChiNhanh() {
        return chiNhanh;
    }

    public void setChiNhanh(ChiNhanh chiNhanh) {
        this.chiNhanh = chiNhanh;
    }

    public List<LichHoc> getLichHoc() {
        return lichHoc;
    }

    public void setLichHoc(List<LichHoc> lichHoc) {
        this.lichHoc = lichHoc;
    }
}
