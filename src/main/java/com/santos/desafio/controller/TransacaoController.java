package com.santos.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.santos.desafio.dto.TransacaoRequest;
import com.santos.desafio.service.TransacaoService;

@RequestMapping("/transacao")
@RestController
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarTransacao(@RequestBody TransacaoRequest request) {
        transacaoService.criarTransacao(request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deletarTransacoes() {
        transacaoService.deletarTransacoes();
    }



}
