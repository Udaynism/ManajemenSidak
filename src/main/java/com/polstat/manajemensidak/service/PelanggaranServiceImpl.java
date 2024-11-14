package com.polstat.manajemensidak.service;

import com.polstat.manajemensidak.dto.PelanggaranDto;
import com.polstat.manajemensidak.entity.Mahasiswa;
import com.polstat.manajemensidak.entity.Pelanggaran;
import com.polstat.manajemensidak.repository.MahasiswaRepository;
import com.polstat.manajemensidak.repository.PelanggaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PelanggaranServiceImpl implements PelanggaranService {

    @Autowired
    private PelanggaranRepository pelanggaranRepository;

    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    @Override
    public Pelanggaran addPelanggaran(PelanggaranDto pelanggaranDto) {
        Mahasiswa mahasiswa = mahasiswaRepository.findByNim(pelanggaranDto.getNim())
                .orElseThrow(() -> new IllegalArgumentException("Mahasiswa tidak ditemukan dengan NIM: " + pelanggaranDto.getNim()));

        Pelanggaran pelanggaran = Pelanggaran.builder()
                .mahasiswa(mahasiswa)
                .tanggalPelanggaran(LocalDate.now())
                .poinPelanggaran(pelanggaranDto.getPoinPelanggaran())
                .keteranganPelanggaran(pelanggaranDto.getKeteranganPelanggaran())
                .build();

        return pelanggaranRepository.save(pelanggaran);
    }

    @Override
    public List<Pelanggaran> getAllPelanggaran() {
        return pelanggaranRepository.findAll();
    }

    @Override
    public List<Pelanggaran> getPelanggaranByMahasiswa(String nim) {
        Mahasiswa mahasiswa = mahasiswaRepository.findByNim(nim)
                .orElseThrow(() -> new IllegalArgumentException("Mahasiswa tidak ditemukan dengan NIM: " + nim));
        return pelanggaranRepository.findByMahasiswa(mahasiswa);
    }

    @Override
    public Pelanggaran updatePelanggaran(Long id, PelanggaranDto pelanggaranDto) {
        Pelanggaran pelanggaran = pelanggaranRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pelanggaran tidak ditemukan dengan ID: " + id));
        pelanggaran.setPoinPelanggaran(pelanggaranDto.getPoinPelanggaran());
        pelanggaran.setKeteranganPelanggaran(pelanggaranDto.getKeteranganPelanggaran());

        return pelanggaranRepository.save(pelanggaran);
    }

    @Override
    public void deletePelanggaran(Long id) {
        Pelanggaran pelanggaran = pelanggaranRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pelanggaran tidak ditemukan dengan ID: " + id));
        pelanggaranRepository.delete(pelanggaran);
    }
}
