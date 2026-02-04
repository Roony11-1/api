package com.api.api_bot.model;

import org.springframework.data.annotation.Id;

import com.api.api_bot.dto.UnidadDTO;
import com.api.api_bot.interfaces.IEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Unidad implements IEntity<UnidadDTO>
{
    @Id
    private String id;
    private String discordId;
    private String nombre;
    private Integer nivel;

    @Override
    public UnidadDTO toDTO() 
    {
        return UnidadDTO.builder()
            .id(this.id)
            .discordId(this.discordId)
            .nombre(this.nombre)
            .nivel(this.nivel)
            .build();
    }

    
}
