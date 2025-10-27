package br.com.andrew.monitoramento;

import br.com.andrew.monitoramento.config.enums.TipoLog;
import br.com.andrew.monitoramento.model.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface LogsRepository extends MongoRepository<Log, String> {
    Optional<List<Log>> findByTipo(TipoLog tipo);
    Optional<List<Log>> findByDataAfter(LocalDateTime dataMinima);

}
