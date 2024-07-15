package com.luizpacheco.worshopmongo.services;

import com.luizpacheco.worshopmongo.domain.entitie.User;
import com.luizpacheco.worshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
}