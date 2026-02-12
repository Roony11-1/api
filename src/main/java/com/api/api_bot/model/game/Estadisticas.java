package com.api.api_bot.model.game;

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
