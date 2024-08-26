package com.luizpacheco.worshopmongo.dto;

import com.luizpacheco.worshopmongo.domain.User;

import java.io.Serializable;

public record AuthorDTO(String id, String name) implements Serializable {

    public AuthorDTO(User user) {
        this(user.getId(), user.getName());
    }
}