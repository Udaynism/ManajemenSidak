package com.polstat.manajemensidak.mapper;

import com.polstat.manajemensidak.dto.UserDto;
import com.polstat.manajemensidak.entity.User;

public class UserMapper {

    public static User mapToUser(UserDto userDto) {
        return User.builder()
                .id_SPD(userDto.getId_SPD())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .nim(userDto.getNim())
                .address(userDto.getAddress())
                .phoneNumber(userDto.getPhoneNumber())
                .build();
    }

    public static UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .id_SPD(user.getId_SPD())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .nim(user.getNim())
                .address(user.getAddress())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
