package com.luizpacheco.worshopmongo.repository;

import com.luizpacheco.worshopmongo.domain.entitie.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}