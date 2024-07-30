package org.tmo.taskmanagersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.tmo.taskmanagersystem.model.Users;
import org.tmo.taskmanagersystem.service.UsersService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    // Bütün kullanıcı kayıtları teslim al
    @GetMapping
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    // ID'si üzerinden kullanıcı kaydını teslim al
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        Users users = usersService.getUserById(id);
        if (users != null) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Yeni bir kullanıcı kaydı oluştur
    @PostMapping
    public Users createUser(@RequestBody Users users) {
        return usersService.createUser(users);
    }

    // Mevcut bir kullanıcı kaydını güncelle
    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users usersDetails) {
        Users updatedUsers = usersService.updateUser(id, usersDetails);
        if (updatedUsers != null) {
            return ResponseEntity.ok(updatedUsers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Bir kullanıcı kaydını sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // Bir kullanıcının bazı bilgilerini güncelle
    @PatchMapping("/{id}")
    public ResponseEntity<Users>
                 partialUpdateUser(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Users updatedUser = usersService.partialUpdateUser(id, updates);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}