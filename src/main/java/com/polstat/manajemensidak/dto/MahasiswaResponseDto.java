package com.polstat.manajemensidak.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MahasiswaResponseDto {
    private Long id;
    private String nim;
    private String name;
    private String address;
    private String phoneNumber;
    private Integer totalPoinPelanggaran;  // Menyertakan total poin pelanggaran
}
