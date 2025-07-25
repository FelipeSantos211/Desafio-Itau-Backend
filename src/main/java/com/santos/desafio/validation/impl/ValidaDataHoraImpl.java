package com.santos.desafio.validation.impl;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Component;

import com.santos.desafio.dto.TransacaoRequest;
import com.santos.desafio.exception.DataHoraInvalidaException;
import com.santos.desafio.validation.Validar;

@Component
public class ValidaDataHoraImpl implements Validar{

    @Override
    public void validar(TransacaoRequest request) {
        if(request.dataHora().isAfter(OffsetDateTime.now())) {
            throw new DataHoraInvalidaException("A data e hora da transação não podem ser no futuro.");
        }
    }


}