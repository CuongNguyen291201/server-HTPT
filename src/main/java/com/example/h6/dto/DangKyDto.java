package com.example.h6.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DangKyDto {
    private Long id;

    @NotNull
    private Long idSinhVien;

    @NotNull
    private Long idLopHocPhan;
}
