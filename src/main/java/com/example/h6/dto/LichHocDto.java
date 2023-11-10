package com.example.h6.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LichHocDto {
    private Long id;

    @NotNull
    private int thu;

    @NotNull
    private int kip;

    @NotNull
    private String phong;

    @NotNull
    private Long idGiangVien;

    @NotNull
    private Long idLopHocPhan;
}
