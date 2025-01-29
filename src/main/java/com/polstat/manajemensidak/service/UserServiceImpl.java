package com.polstat.manajemensidak.service;

import com.polstat.manajemensidak.dto.UserDto;
import com.polstat.manajemensidak.entity.User;
import com.polstat.manajemensidak.mapper.UserMapper;
import com.polstat.manajemensidak.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User user = userRepository.save(UserMapper.mapToUser(userDto));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found with email: " + email));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public UserDto updateProfile(String email, UserDto userDto) {
        // Cari user berdasarkan email
        User existingUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found with email: " + email));

        // Perbarui data user
        existingUser.setName(userDto.getName());
        existingUser.setAddress(userDto.getAddress()); // Tambahkan address
        existingUser.setPhoneNumber(userDto.getPhoneNumber()); // Tambahkan phoneNumber

        // Simpan perubahan
        User updatedUser = userRepository.save(existingUser);

        // Kembalikan user yang diperbarui sebagai DTO
        return UserMapper.mapToUserDto(updatedUser);
    }


    @Override
    public void changePassword(String email, String oldPassword, String newPassword) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found with email: " + email));

        // Verifikasi password lama
        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new IllegalArgumentException("Old password is incorrect");
        }

        // Set new password
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    @Override
    public void deleteAccount(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found with email: " + email));
        userRepository.delete(user);
    }

    @Override
    public boolean validatePassword(String email, String inputPassword) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User tidak ditemukan dengan email: " + email));

        return passwordEncoder.matches(inputPassword, user.getPassword());
    }
}
