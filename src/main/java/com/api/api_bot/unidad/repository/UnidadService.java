package com.api.api_bot.unidad.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.api_bot.unidad.model.Estadisticas;
import com.api.api_bot.unidad.model.Unidad;
import com.api.api_bot.unidad.model.classes.Clase;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UnidadService 
{
    private final UnidadRepository _unidadRepository;
    private final ClaseRepository _classRepository;

    public List<Unidad> findByDiscordId(String discordId)
    {
        List<Unidad> unidades = _unidadRepository.findByDiscordId(discordId);
        return unidades;
    }

    public Unidad save(Unidad unidad)
    {
        return _unidadRepository.save(unidad);
    }

    public Unidad saveDiscord(String nombre, String claseId, String discordId) 
    {
        Clase clase = _classRepository.findById(claseId)
            .orElse(_classRepository.save(new Clase("Mirmidón", new Estadisticas(1))));

        Unidad unidad = Unidad.builder()
            .nombre(nombre != null ? nombre : "Unidad Sin Nombre")
            .nivel(1)
            .discordId(discordId)
            .clase(clase)
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
