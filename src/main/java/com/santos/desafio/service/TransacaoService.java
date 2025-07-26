package com.santos.desafio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santos.desafio.domain.Transacao;
import com.santos.desafio.dto.TransacaoRequest;
import com.santos.desafio.validation.Validar;

@Service
public class TransacaoService {

    private List<Transacao> transacoes = new ArrayList<>();

    @Autowired
    private List<Validar> validadores;

    public void criarTransacao(TransacaoRequest request) {
        validadores.forEach(validador -> validador.validar(request));
        transacoes.add(new Transacao(request.valor(), request.dataHora()));
        System.out.println(transacoes.size() + " transações registradas.");
    }

    public void deletarTransacoes() {
        transacoes.clear();
        System.out.println("Todas as transações foram deletadas.");
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}