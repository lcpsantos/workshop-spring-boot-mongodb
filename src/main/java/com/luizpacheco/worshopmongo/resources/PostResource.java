package com.luizpacheco.worshopmongo.resources;

import com.luizpacheco.worshopmongo.domain.Post;
import com.luizpacheco.worshopmongo.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/posts")
public class PostResource {

    private final PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        var post = service.findById(id);

        return ResponseEntity.ok().body(post);
    }
}