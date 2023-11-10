package com.example.h6.entity;

import jakarta.persistence.*;

import java.util.List;

@Table
@Entity(name = "LopHocPhan")
public class LopHocPhan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10)
    private Long id;

    @Column(name = "svToiDa", length = 10)
    private int svToiDa;
    @Column(name = "namHoc", length = 255)
    private String namHoc;

    @Column(name = "hocKy", length = 10)
    private int hocKy;

    @ManyToOne
    @JoinColumn(name = "maChiNhanh")
    private ChiNhanh chiNhanh;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maMonHoc")
    private MonHoc monHoc;

    @OneToMany(mappedBy = "lopHocPhan", cascade = CascadeType.ALL)
    private List<DangKy> dangKy;

    @OneToMany(mappedBy = "lopHocPhan", cascade = CascadeType.ALL)
    private List<LichHoc> lichHoc;

    public LopHocPhan() {

    }

    public LopHocPhan(int id) {

    }

    public LopHocPhan(Long id, int svToiDa, String namHoc, int hocKy) {
        this.id = id;
        this.svToiDa = svToiDa;
        this.namHoc = namHoc;
        this.hocKy = hocKy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSvToiDa() {
        return svToiDa;
    }

    public void setSvToiDa(int svToiDa) {
        this.svToiDa = svToiDa;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

    public ChiNhanh getChiNhanh() {
        return chiNhanh;
    }

    public void setChiNhanh(ChiNhanh chiNhanh) {
        this.chiNhanh = chiNhanh;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }
}
