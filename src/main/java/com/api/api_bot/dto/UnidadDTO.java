package com.api.api_bot.dto;

import com.api.api_bot.model.game.Unidad;
import com.api.api_bot.model.game.classes.Clase;

import lombok.Data;

@Data
public class UnidadDTO 
{
    private String id;
    private String discordId;
    private String nombre;
    private Integer nivel;
    private Clase clase;

    public UnidadDTO(Unidad unidad)
    {
        this.id = unidad.getId();
        this.discordId = unidad.getDiscordId();
        this.nombre = unidad.getNombre();
        this.nivel = unidad.getNivel();
        this.clase = unidad.getClase();
    }
}
