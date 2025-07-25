package com.santos.desafio.dto;

import java.time.OffsetDateTime;

public record TransacaoRequest(Double valor, OffsetDateTime dataHora) {
}