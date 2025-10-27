package br.com.andrew.monitoramento.service;

import br.com.andrew.monitoramento.LogsRepository;
import br.com.andrew.monitoramento.dto.LogRecord;
import br.com.andrew.monitoramento.mapper.LogMapper;
import br.com.andrew.monitoramento.model.Log;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LogConsumerService {

    private final LogsRepository logsRepository;
    private final LogMapper logMapper;

    @KafkaListener(topics = "${app.kafka.topics.logs}", groupId = "grupo-logistica", containerFactory = "logsKafkaListenerContainerFactory")
    public void logListener(LogRecord logRecord){

        Log evento = logMapper.toEntity(logRecord);

        log.info(String.valueOf(evento));

        logsRepository.save(evento);
    }
}
