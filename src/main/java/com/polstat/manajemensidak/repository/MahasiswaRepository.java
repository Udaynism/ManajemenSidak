package com.polstat.manajemensidak.repository;

import com.polstat.manajemensidak.entity.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long> {
    Optional<Mahasiswa> findByNim(String nim);  // Mencari mahasiswa berdasarkan NIM
}
