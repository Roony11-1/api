package com.api.api_bot.comidas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.api.api_bot.comidas.domain.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>
{

}
