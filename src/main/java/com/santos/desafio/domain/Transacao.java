package com.santos.desafio.domain;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Transacao {
    private Double valor;
    private OffsetDateTime dataHora;
}
