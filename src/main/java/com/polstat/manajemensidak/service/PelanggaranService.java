package com.polstat.manajemensidak.service;

import com.polstat.manajemensidak.dto.PelanggaranDto;
import com.polstat.manajemensidak.entity.Pelanggaran;

import java.util.List;

public interface PelanggaranService {
    Pelanggaran addPelanggaran(PelanggaranDto pelanggaranDto);  // Sesuaikan tipe parameter ke PelanggaranDto
    List<Pelanggaran> getAllPelanggaran();
    List<Pelanggaran> getPelanggaranByMahasiswa(String nim);
    Pelanggaran updatePelanggaran(Long id, PelanggaranDto pelanggaranDto);  // Metode untuk update pelanggaran
    void deletePelanggaran(Long id);
    int getTotalPoinByNim(String nim);
}
