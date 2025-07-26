package com.santos.desafio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import com.santos.desafio.dto.EstatisticaResponse;
import com.santos.desafio.service.EstatisticaService;

@RequestMapping("/estatistica")
@RestController

public class EstatisticaController {

    @Autowired
    private EstatisticaService estatisticaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public EstatisticaResponse consultarEstatisticas() {
        return estatisticaService.consultarEstatisticas();
    }
}
