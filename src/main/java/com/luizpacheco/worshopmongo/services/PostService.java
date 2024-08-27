package com.luizpacheco.worshopmongo.services;

import com.luizpacheco.worshopmongo.domain.Post;
import com.luizpacheco.worshopmongo.repository.PostRepository;
import com.luizpacheco.worshopmongo.services.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository repository;

    public Post findById(String id) {
        var post = repository.findById(id).orElse(null);
        if (Objects.isNull(post)) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return post;
    }

    public List<Post> findByTitle(String text) {
        return repository.findByTitleContainingIgnoreCase(text);
    }
}