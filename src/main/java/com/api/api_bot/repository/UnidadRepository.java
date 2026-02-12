package com.api.api_bot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.api.api_bot.model.game.Unidad;

import java.util.List;

@Repository
public interface UnidadRepository extends MongoRepository<Unidad, String>
{
    List<Unidad> findByDiscordId(String discordId);
    long countByDiscordId(String discordId);
    void deleteByDiscordId(String discordId);
}
