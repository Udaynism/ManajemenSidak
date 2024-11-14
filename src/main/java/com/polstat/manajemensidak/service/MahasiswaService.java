package com.polstat.manajemensidak.service;

import com.polstat.manajemensidak.dto.MahasiswaResponseDto;
import com.polstat.manajemensidak.entity.Mahasiswa;

import java.util.List;

public interface MahasiswaService {
    List<Mahasiswa> getAllMahasiswa();
    Mahasiswa addMahasiswa(Mahasiswa mahasiswa);
    MahasiswaResponseDto getMahasiswaDetailByNim(String nim);  // Pastikan namanya konsisten di sini
    Mahasiswa updateMahasiswa(String nim, Mahasiswa mahasiswa);
    void deleteMahasiswa(String nim);
    Integer getTotalPoinByNim(String nim);
}
