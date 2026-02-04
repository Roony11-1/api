package com.api.api_bot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.api.api_bot.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>
{
    
}
