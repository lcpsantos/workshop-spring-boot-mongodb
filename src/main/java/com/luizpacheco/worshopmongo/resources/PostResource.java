package com.luizpacheco.worshopmongo.resources;

import com.luizpacheco.worshopmongo.domain.Post;
import com.luizpacheco.worshopmongo.resources.util.URL;
import com.luizpacheco.worshopmongo.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        var post = service.findByTitle(text);

        return ResponseEntity.ok().body(post);
    }
}