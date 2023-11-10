package com.example.h6.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LopHocPhanDto {
    private Long id;

    @NotNull
    private int svToiDa;

    @NotNull
    private String namHoc;

    @NotNull
    private int hocKy;

    @NotNull
    private Long idChiNhanh;

    @NotNull
    private Long idMonHoc;
}
