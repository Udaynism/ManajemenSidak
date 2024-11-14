package com.polstat.manajemensidak.dto;

import lombok.Data;

@Data
public class PelanggaranDto {

    private String nim;  // Identifikasi mahasiswa berdasarkan NIM
    private int poinPelanggaran;
    private String keteranganPelanggaran;
}
