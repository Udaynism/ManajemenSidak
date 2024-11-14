package com.polstat.manajemensidak.service;

import com.polstat.manajemensidak.dto.MahasiswaResponseDto;
import com.polstat.manajemensidak.entity.Mahasiswa;
import com.polstat.manajemensidak.repository.MahasiswaRepository;
import com.polstat.manajemensidak.repository.PelanggaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MahasiswaServiceImpl implements MahasiswaService {

    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    @Autowired
    private PelanggaranRepository pelanggaranRepository;

    @Override
    public List<Mahasiswa> getAllMahasiswa() {
        return mahasiswaRepository.findAll();
    }

    @Override
    public Mahasiswa addMahasiswa(Mahasiswa mahasiswa) {
        return mahasiswaRepository.save(mahasiswa);
    }

    @Override
    public MahasiswaResponseDto getMahasiswaDetailByNim(String nim) {
        Mahasiswa mahasiswa = mahasiswaRepository.findByNim(nim)
                .orElseThrow(() -> new IllegalArgumentException("Mahasiswa tidak ditemukan dengan NIM: " + nim));

        Integer totalPoinPelanggaran = pelanggaranRepository.findTotalPoinByNim(nim);

        return new MahasiswaResponseDto(
                mahasiswa.getId(),
                mahasiswa.getNim(),
                mahasiswa.getName(),
                mahasiswa.getAddress(),
                mahasiswa.getPhoneNumber(),
                totalPoinPelanggaran != null ? totalPoinPelanggaran : 0
        );
    }

    @Override
    public Integer getTotalPoinByNim(String nim) {
        return pelanggaranRepository.findTotalPoinByNim(nim);
    }

    @Override
    public Mahasiswa updateMahasiswa(String nim, Mahasiswa mahasiswaDetails) {
        Mahasiswa mahasiswa = mahasiswaRepository.findByNim(nim)
                .orElseThrow(() -> new IllegalArgumentException("Mahasiswa tidak ditemukan dengan NIM: " + nim));
        mahasiswa.setName(mahasiswaDetails.getName());
        mahasiswa.setAddress(mahasiswaDetails.getAddress());
        mahasiswa.setPhoneNumber(mahasiswaDetails.getPhoneNumber());
        return mahasiswaRepository.save(mahasiswa);
    }

    @Override
    public void deleteMahasiswa(String nim) {
        Mahasiswa mahasiswa = mahasiswaRepository.findByNim(nim)
                .orElseThrow(() -> new IllegalArgumentException("Mahasiswa tidak ditemukan dengan NIM: " + nim));
        mahasiswaRepository.delete(mahasiswa);
    }
}
