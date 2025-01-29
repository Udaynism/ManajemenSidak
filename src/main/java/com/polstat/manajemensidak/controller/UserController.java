package com.polstat.manajemensidak.controller;

import com.polstat.manajemensidak.dto.UserDto;
import com.polstat.manajemensidak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserDto> getProfile(Principal principal) {
        String email = principal.getName();
        UserDto user = userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/profile")
    public ResponseEntity<UserDto> updateProfile(@RequestBody UserDto userDto, Principal principal) {
        String email = principal.getName();
        UserDto updatedUser = userService.updateProfile(email, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @PutMapping("/profile/change-password")
    public ResponseEntity<String> changePassword(@RequestBody Map<String, String> passwordMap, Principal principal) {
        String email = principal.getName();
        String oldPassword = passwordMap.get("oldPassword");
        String newPassword = passwordMap.get("newPassword");

        userService.changePassword(email, oldPassword, newPassword);
        return ResponseEntity.ok("Password berhasil diubah");
    }

    @DeleteMapping("/profile")
    public ResponseEntity<String> deleteAccount(Principal principal) {
        String email = principal.getName();
        userService.deleteAccount(email);
        return ResponseEntity.ok("Akun berhasil dihapus");
    }

    @PostMapping("/profile/validate-password")
    public ResponseEntity<String> validatePassword(@RequestBody Map<String, String> request, Principal principal) {
        String email = principal.getName();
        String inputPassword = request.get("password");

        // Ambil user dari database
        UserDto user = userService.getUserByEmail(email);

        // Validasi password
        if (userService.validatePassword(email, inputPassword)) {
            return ResponseEntity.ok("Password valid");
        } else {
            return ResponseEntity.status(403).body("Password salah");
        }
    }



}
