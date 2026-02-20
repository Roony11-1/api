package com.api.api_bot.comidas.domain;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
@TypeAlias("Producto")
@CompoundIndex(name = "name_brand_unique", def = "{'name': 1, 'brand': 1}", unique = true)
public class Product 
{
    @Id
    private String id;

    private String name;
    private String brand;
    private List<String> categoryIds = new ArrayList<>();

    private MeasurementUnit baseUnit; // GRAMS o MILLILITERS

    private Macronutrients macrosPer100Units;

    private Instant createdAt = Instant.now();
}