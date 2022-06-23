package com.bruno.apizinha.controllers;

import com.bruno.apizinha.dtos.UserResponseDTO;
import com.bruno.apizinha.dtos.UsuarioDTO;
import com.bruno.apizinha.entities.User;
import com.bruno.apizinha.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserResponseDTO> usersResponseDTO = UserResponseDTO.from(users);
        return new ResponseEntity<>(usersResponseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UsuarioDTO dto) {
        User user = dto.toUser();
        User created = userService.createUser(user);
        return new ResponseEntity<>(UserResponseDTO.from(created), HttpStatus.CREATED);
    }
}
