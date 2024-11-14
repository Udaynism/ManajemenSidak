package com.polstat.manajemensidak.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id_SPD;
    private String name;
    private String email;
    private String password;
    private String nim;
    private String address;
    private String phoneNumber;
}
