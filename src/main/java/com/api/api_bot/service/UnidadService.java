package com.api.api_bot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.api_bot.model.Unidad;
import com.api.api_bot.repository.UnidadRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UnidadService 
{
    private final UnidadRepository _unidadRepository;

    public List<Unidad> findByDiscordId(String discordId)
    {
        List<Unidad> unidades = _unidadRepository.findByDiscordId(discordId);
        return unidades;
    }

    public Unidad save(Unidad unidad)
    {
        return _unidadRepository.save(unidad);
    }

    public Unidad saveDiscord(String nombre, Integer nivel, String discordId) 
    {
        Unidad unidad = Unidad.builder()
            .nombre(nombre != null ? nombre : "Unidad Sin Nombre")
            .nivel(nivel != null ? nivel : 1)
            .discordId(discordId)
            .build();

        return _unidadRepository.save(unidad);
    }

    public long deleteByDiscordId(String discordId)
    {
        long count = _unidadRepository.countByDiscordId(discordId);
        _unidadRepository.deleteByDiscordId(discordId);

        return count;
    }
}
