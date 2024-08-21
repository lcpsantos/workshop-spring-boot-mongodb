package com.luizpacheco.worshopmongo.repository;

import com.luizpacheco.worshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PostRepository extends MongoRepository<Post, String> {

}