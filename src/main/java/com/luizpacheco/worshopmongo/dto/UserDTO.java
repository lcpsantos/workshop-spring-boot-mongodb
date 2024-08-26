package com.luizpacheco.worshopmongo.dto;

import com.luizpacheco.worshopmongo.domain.User;

public record UserDTO(String id, String name, String email) {

    public UserDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }
}