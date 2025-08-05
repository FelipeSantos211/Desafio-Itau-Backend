package com.santos.desafio.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santos.desafio.domain.Transacao;
import com.santos.desafio.dto.TransacaoRequest;
import com.santos.desafio.validation.Validar;

@Service
public class TransacaoService {

    private static final Logger logger = LoggerFactory.getLogger(TransacaoService.class);

    private List<Transacao> transacoes = new ArrayList<>();

    @Autowired
    private List<Validar<TransacaoRequest>> validadores;

    public void criarTransacao(TransacaoRequest request) {
        validadores.forEach(validador -> validador.validar(request));
        transacoes.add(new Transacao(request.valor(), request.dataHora()));
        logger.info("{} transações registradas.", transacoes.size());
    }

    public void deletarTransacoes() {
        transacoes.clear();
        logger.info("Todas as transações foram deletadas.");
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}