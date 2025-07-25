package com.santos.desafio.validation.impl;

import org.springframework.stereotype.Component;

import com.santos.desafio.dto.TransacaoRequest;
import com.santos.desafio.exception.ValorInvalidoException;
import com.santos.desafio.validation.Validar;

@Component
public class ValidaValorImpl implements Validar {

    @Override
    public void validar(TransacaoRequest request) {
        if (request.valor() <= 0) {
            throw new ValorInvalidoException("O valor da transação deve ser maior que zero.");
        }
    }

}
