package br.com.andrew.monitoramento.dto;

import java.time.LocalDateTime;

public record LogRecord(
        String tipo,
        String mensagem,
        LocalDateTime dataHora,
        String origem,
        String detalhes
) {}
