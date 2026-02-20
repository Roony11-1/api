package com.api.api_bot.unidad.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Estadisticas 
{
    private int pv;

    public Estadisticas(int base)
    {
        this.pv = base;
    }
}
