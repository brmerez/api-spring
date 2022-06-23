package com.bruno.apizinha.dtos;

import com.bruno.apizinha.entities.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserResponseDTO {
    private UUID id;
    private String name;
    private String email;

    public static UserResponseDTO from(@NotNull User user) {
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
    }
    public static List<UserResponseDTO> from(@NotNull List<User> users) {
        return users.stream().map(UserResponseDTO::from).collect(java.util.stream.Collectors.toList());
    }
}
