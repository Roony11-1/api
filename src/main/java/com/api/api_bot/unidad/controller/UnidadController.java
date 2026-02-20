package com.api.api_bot.unidad.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.api_bot.unidad.dto.UnidadDTO;
import com.api.api_bot.unidad.model.Unidad;
import com.api.api_bot.unidad.repository.UnidadService;

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
            .map(UnidadDTO::new)
            .toList();

        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<UnidadDTO> save(@RequestBody Unidad unidad)
    {
        Unidad unidadSaved = _unidadService.save(unidad);

        return ResponseEntity.ok(new UnidadDTO(unidadSaved));
    }

    @PostMapping("/discord")
    public ResponseEntity<UnidadDTO> saveDiscord(
        @RequestParam(required = false) String nombre,
        @RequestParam String claseId,
        @RequestParam String discordId)
    {
        Unidad unidadSaved = _unidadService.saveDiscord(nombre, claseId, discordId);

        return ResponseEntity.ok(new UnidadDTO(unidadSaved));
    }

    @DeleteMapping("/discord")
    public ResponseEntity<Long> deleteByDiscordId(@RequestParam String discordId)
    {
        long count = _unidadService.deleteByDiscordId(discordId);
        return ResponseEntity.ok(count);
    }
}
