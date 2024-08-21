package com.luizpacheco.worshopmongo.services;

import com.luizpacheco.worshopmongo.domain.User;
import com.luizpacheco.worshopmongo.dto.UserDTO;
import com.luizpacheco.worshopmongo.repository.UserRepository;
import com.luizpacheco.worshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        var user = repository.findById(id).orElse(null);
        if (Objects.isNull(user)) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user;
    }

    public User insert(User user) {
        return repository.insert(user);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User update(User user) {
        var newUser = findById(user.getId());
        updateData(newUser, user);

        return repository.save(newUser);
    }

    private void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}