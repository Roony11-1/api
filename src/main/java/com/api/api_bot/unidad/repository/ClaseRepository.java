package com.api.api_bot.unidad.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.api.api_bot.unidad.model.classes.Clase;


@Repository
public interface ClaseRepository extends MongoRepository<Clase, String>
{

}
