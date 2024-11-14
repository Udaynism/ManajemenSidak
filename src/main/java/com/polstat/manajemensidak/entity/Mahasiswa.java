package com.polstat.manajemensidak.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mahasiswa")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mahasiswa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nim;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phoneNumber;
}
