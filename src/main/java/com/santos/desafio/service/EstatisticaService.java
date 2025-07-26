package com.santos.desafio.service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.santos.desafio.domain.Transacao;
import com.santos.desafio.dto.EstatisticaResponse;

@Service
public class EstatisticaService {

    @Autowired
    private TransacaoService transacaoService;

    @Value("${estatistica.periodo.segundos:60}")
    private int periodoSegundos;

    public EstatisticaResponse consultarEstatisticas() {
        OffsetDateTime limite = OffsetDateTime.now().minusSeconds(periodoSegundos);

        DoubleSummaryStatistics statistics = transacaoService.getTransacoes().stream()
                .filter(transacao -> !transacao.getDataHora().isBefore(limite))
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();

        if (statistics.getCount() == 0) {
            return new EstatisticaResponse(0L, 0.0, 0.0, 0.0, 0.0);
        }

        return new EstatisticaResponse(
                statistics.getCount(),
                statistics.getSum(),
                statistics.getAverage(),
                statistics.getMin(),
                statistics.getMax()
        );
    }

}
