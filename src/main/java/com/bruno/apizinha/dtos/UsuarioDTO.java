package com.bruno.apizinha.dtos;

import com.bruno.apizinha.entities.User;
import lombok.Getter;

@Getter
public class UsuarioDTO {
    private String name;
    private String email;
    private String password;

    public User toUser() {
        return new User(name, email, password);
    }

}
