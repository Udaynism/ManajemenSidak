package com.polstat.manajemensidak.service;

import com.polstat.manajemensidak.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserByEmail(String email);
    UserDto updateProfile(String email, UserDto userDto);
    void changePassword(String email, String oldPassword, String newPassword);
    void deleteAccount(String email);
}

