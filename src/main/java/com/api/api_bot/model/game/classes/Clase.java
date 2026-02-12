package com.api.api_bot.model.game.classes;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.api.api_bot.model.game.Estadisticas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clase")
@TypeAlias("Clase")
public class Clase 
{
    @Id
    private String name;
    private Estadisticas estadisticasBase;
}
