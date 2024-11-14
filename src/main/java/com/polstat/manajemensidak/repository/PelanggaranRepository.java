package com.polstat.manajemensidak.repository;

import com.polstat.manajemensidak.entity.Mahasiswa;
import com.polstat.manajemensidak.entity.Pelanggaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PelanggaranRepository extends JpaRepository<Pelanggaran, Long> {

    List<Pelanggaran> findByMahasiswa(Mahasiswa mahasiswa);

    // Menghitung total poin pelanggaran untuk mahasiswa berdasarkan NIM
    @Query("SELECT SUM(p.poinPelanggaran) FROM Pelanggaran p WHERE p.mahasiswa.nim = :nim")
    Integer findTotalPoinByNim(@Param("nim") String nim);
}
