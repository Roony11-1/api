package com.api.api_bot.unidad.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;

import com.api.api_bot.shared.interfaces.IEntity;
import com.api.api_bot.unidad.dto.UnidadDTO;
import com.api.api_bot.unidad.model.classes.Clase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@TypeAlias("Unidad")
public class Unidad implements IEntity<UnidadDTO>
{
    @Id
    private String id;
    private String discordId;
    private String nombre;
    private Integer nivel;
    private Clase clase;
}
