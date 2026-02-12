package com.api.api_bot.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.api_bot.dto.UnidadDTO;
import com.api.api_bot.model.game.Unidad;
import com.api.api_bot.service.UnidadService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/unidad/v1")
public class UnidadController
{

    private final UnidadService _unidadService;

    // GET /unidad/v1?discordId=123
    @GetMapping
    public ResponseEntity<List<UnidadDTO>> findByDiscordId(@RequestParam String discordId) 
    {
        List<Unidad> unidades = _unidadService.findByDiscordId(discordId);

        if (unidades.isEmpty())
            return ResponseEntity.notFound().build();

        List<UnidadDTO> dtos = unidades
            .stream()
            .map(unidad -> unidad.toDTO())
            .toList();

        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<UnidadDTO> save(@RequestBody Unidad unidad)
    {
        return ResponseEntity.ok(
            _unidadService.save(unidad).toDTO());
    }

    @PostMapping("/discord")
    public ResponseEntity<UnidadDTO> saveDiscord(
        @RequestParam(required = false) String nombre,
        @RequestParam(required = false) Integer nivel,
        @RequestParam String discordId)
    {
        return ResponseEntity.ok(
            _unidadService.saveDiscord(nombre, nivel, discordId).toDTO());
    }

    @DeleteMapping("/discord")
    public ResponseEntity<Long> deleteByDiscordId(@RequestParam String discordId)
    {
        long count = _unidadService.deleteByDiscordId(discordId);
        return ResponseEntity.ok(count);
    }
}
