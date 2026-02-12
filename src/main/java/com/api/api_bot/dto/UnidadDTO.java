package com.api.api_bot.dto;

import com.api.api_bot.model.game.classes.Clase;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UnidadDTO 
{
    private String id;
    private String discordId;
    private String nombre;
    private Integer nivel;
    private Clase clase;
}
