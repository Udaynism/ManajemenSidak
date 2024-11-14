package com.polstat.manajemensidak.service;

import com.polstat.manajemensidak.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserByEmail(String email);
}
