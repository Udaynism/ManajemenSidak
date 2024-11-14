package com.polstat.manajemensidak.controller;

import com.polstat.manajemensidak.dto.MahasiswaResponseDto;
import com.polstat.manajemensidak.entity.Mahasiswa;
import com.polstat.manajemensidak.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mahasiswa")
public class MahasiswaController {

    @Autowired
    private MahasiswaService mahasiswaService;

    @GetMapping
    public ResponseEntity<List<Mahasiswa>> getAllMahasiswa() {
        return ResponseEntity.ok(mahasiswaService.getAllMahasiswa());
    }

    @PostMapping
    public ResponseEntity<Mahasiswa> addMahasiswa(@RequestBody Mahasiswa mahasiswa) {
        return ResponseEntity.status(201).body(mahasiswaService.addMahasiswa(mahasiswa));
    }

    @GetMapping("/{nim}")
    public ResponseEntity<MahasiswaResponseDto> getMahasiswaByNim(@PathVariable String nim) {
        return ResponseEntity.ok(mahasiswaService.getMahasiswaDetailByNim(nim));
    }

    // Endpoint untuk mendapatkan total poin pelanggaran mahasiswa
    @GetMapping("/{nim}/totalpoin")
    public ResponseEntity<Map<String, Integer>> getTotalPoinByNim(@PathVariable String nim) {
        Integer totalPoin = mahasiswaService.getTotalPoinByNim(nim);
        return ResponseEntity.ok(Map.of("totalPoinPelanggaran", totalPoin != null ? totalPoin : 0));
    }

    // Endpoint untuk mengedit data mahasiswa
    @PutMapping("/{nim}")
    public ResponseEntity<Mahasiswa> updateMahasiswa(@PathVariable String nim, @RequestBody Mahasiswa mahasiswa) {
        return ResponseEntity.ok(mahasiswaService.updateMahasiswa(nim, mahasiswa));
    }

    // Endpoint untuk menghapus mahasiswa
    @DeleteMapping("/{nim}")
    public ResponseEntity<String> deleteMahasiswa(@PathVariable String nim) {
        mahasiswaService.deleteMahasiswa(nim);
        return ResponseEntity.ok("Mahasiswa berhasil dihapus");
    }
}
