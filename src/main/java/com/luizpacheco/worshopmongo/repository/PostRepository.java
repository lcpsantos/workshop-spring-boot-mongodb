package com.luizpacheco.worshopmongo.repository;

import com.luizpacheco.worshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PostRepository extends MongoRepository<Post, String> {

    //Consulta simples com @Query
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }") // ?0 = first parameter of the method (text) and 'i' = case insensitive
    List<Post> searchTitle(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);
}