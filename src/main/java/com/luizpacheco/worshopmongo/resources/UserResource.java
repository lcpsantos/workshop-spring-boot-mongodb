package com.luizpacheco.worshopmongo.resources;

import com.luizpacheco.worshopmongo.domain.Post;
import com.luizpacheco.worshopmongo.domain.User;
import com.luizpacheco.worshopmongo.dto.UserDTO;
import com.luizpacheco.worshopmongo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();

        List<UserDTO> listDto = list.stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        var user = service.findById(id);

        return ResponseEntity.ok().body(new UserDTO(user));
    }

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        var user = service.findById(id);

        return ResponseEntity.ok().body(user.getPosts());
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO) {
        var user = service.fromDTO(userDTO);
        service.insert(user);

        var uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody UserDTO userDTO, @PathVariable String id) {
        var user = service.fromDTO(userDTO);
        user.setId(id);
        service.update(user);

        return ResponseEntity.noContent().build();
    }
}