package com.polstat.manajemensidak.mapper;

import com.polstat.manajemensidak.dto.UserDto;
import com.polstat.manajemensidak.entity.User;

public class UserMapper {

    public static User mapToUser(UserDto userDto) {
        return User.builder()
                .id_SPD(userDto.getId_SPD())
                .email(userDto.getEmail())
                .nim(userDto.getNim())
                .name(userDto.getName())
                .password(userDto.getPassword())
                .address(userDto.getAddress()) // Tambahkan address
                .phoneNumber(userDto.getPhoneNumber()) // Tambahkan phoneNumber
                .build();
    }

    public static UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .id_SPD(user.getId_SPD())
                .email(user.getEmail())
                .nim(user.getNim())
                .name(user.getName())
                .address(user.getAddress()) // Tambahkan address
                .phoneNumber(user.getPhoneNumber()) // Tambahkan phoneNumber
                .build();
    }
}

