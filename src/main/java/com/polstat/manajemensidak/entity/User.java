package com.polstat.manajemensidak.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_spd") // Mengubah nama kolom menjadi id_SPD
    private Long id_SPD;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String nim; // Menambahkan NIM sebagai kolom unik

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String address; // Menambahkan kolom address

    @Column(nullable = false)
    private String phoneNumber; // Menambahkan kolom phoneNumber
}
