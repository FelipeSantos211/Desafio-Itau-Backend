package com.santos.desafio.validation.impl;

import org.springframework.stereotype.Component;

import com.santos.desafio.dto.TransacaoRequest;
import com.santos.desafio.exception.CamposInvalidosException;
import com.santos.desafio.validation.Validar;

@Component
public class ValidaCamposPreenchidosImpl implements Validar<TransacaoRequest> {

    @Override
    public void validar(TransacaoRequest request) {
        if (request.valor() == null || request.dataHora() == null) {
            throw new CamposInvalidosException("Os campos 'valor' e 'dataHora' devem ser preenchidos.");
        }
    }

}
    