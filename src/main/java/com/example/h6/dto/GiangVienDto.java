package com.example.h6.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GiangVienDto {
    private Long id;

    @NotNull
    private String ten;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String ngaySinh;

    @NotNull
    private String gioiTinh;

    @NotNull
    private int luong;

    @NotNull
    private Long idChiNhanh;
}
