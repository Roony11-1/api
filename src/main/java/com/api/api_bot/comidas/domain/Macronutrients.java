package com.api.api_bot.comidas.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Macronutrients 
{
    private double calories; // kcal
    private double protein; // g
    private double fat; // g
    private double carbs; // g

    private double sodium; // mg
    private double sugar; // gr
}
