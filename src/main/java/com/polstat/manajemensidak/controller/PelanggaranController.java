package com.polstat.manajemensidak.controller;

import com.polstat.manajemensidak.dto.PelanggaranDto;
import com.polstat.manajemensidak.entity.Pelanggaran;
import com.polstat.manajemensidak.service.PelanggaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pelanggaran")
public class PelanggaranController {

    @Autowired
    private PelanggaranService pelanggaranService;

    @PostMapping
    public ResponseEntity<Pelanggaran> addPelanggaran(@RequestBody PelanggaranDto pelanggaranDto) {
        Pelanggaran pelanggaran = pelanggaranService.addPelanggaran(pelanggaranDto);
        return ResponseEntity.status(201).body(pelanggaran);
    }

    @GetMapping
    public ResponseEntity<List<Pelanggaran>> getAllPelanggaran() {
        return ResponseEntity.ok(pelanggaranService.getAllPelanggaran());
    }

    @GetMapping("/mahasiswa/{nim}")
    public ResponseEntity<List<Pelanggaran>> getPelanggaranByMahasiswa(@PathVariable String nim) {
        return ResponseEntity.ok(pelanggaranService.getPelanggaranByMahasiswa(nim));
    }

    @PutMapping("/{id_pelanggaran}")
    public ResponseEntity<Pelanggaran> updatePelanggaran(@PathVariable("id_pelanggaran") Long id, @RequestBody PelanggaranDto pelanggaranDto) {
        Pelanggaran updatedPelanggaran = pelanggaranService.updatePelanggaran(id, pelanggaranDto);
        return ResponseEntity.ok(updatedPelanggaran);
    }

    // Endpoint untuk menghapus pelanggaran
    @DeleteMapping("/{id_pelanggaran}")
    public ResponseEntity<String> deletePelanggaran(@PathVariable("id_pelanggaran") Long id) {
        pelanggaranService.deletePelanggaran(id);
        return ResponseEntity.ok("Pelanggaran berhasil dihapus");
    }
}
