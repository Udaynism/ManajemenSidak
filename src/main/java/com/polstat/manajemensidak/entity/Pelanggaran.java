package com.polstat.manajemensidak.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "pelanggaran")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pelanggaran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pelanggaran;

    @ManyToOne
    @JoinColumn(name = "nim", referencedColumnName = "nim", nullable = false) // Menggunakan nim sebagai kolom referensi
    private Mahasiswa mahasiswa;

    @Column(nullable = false)
    private int poinPelanggaran;

    @Column(nullable = false)
    private String keteranganPelanggaran;

    @Column(nullable = false)
    private LocalDate tanggalPelanggaran;
}
