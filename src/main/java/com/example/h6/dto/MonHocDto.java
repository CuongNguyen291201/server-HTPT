package com.example.h6.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonHocDto {
    private Long id;

    @NotNull
    private String ten;

    @NotNull
    private int soTc;

    @NotNull
    private Long idChuyenNganh;
}
