package br.com.andrew.monitoramento.service;

import br.com.andrew.monitoramento.LogsRepository;
import br.com.andrew.monitoramento.config.enums.TipoLog;
import br.com.andrew.monitoramento.dto.ApiResponse;
import br.com.andrew.monitoramento.model.Log;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MonitoramentoService {

    private final LogsRepository logsRepository;

    @Transactional(readOnly = true)
    public ApiResponse<List<Log>> listarLogsCadastro(){

        List<Log> lista = logsRepository.findByTipo(TipoLog.cadastro)
                .orElseThrow(() -> new NoSuchElementException("Nenhum log de cadastro encontrado"));

        return ApiResponse.success("Listagem de logs de cadastro realizada com sucesso", lista);
    }

    @Transactional(readOnly = true)
    public ApiResponse<List<Log>> listarLogsEntrada(){

        List<Log> lista = logsRepository.findByTipo(TipoLog.entrada)
                .orElseThrow(() -> new NoSuchElementException("Nenhum log de entrada encontrado"));

        return ApiResponse.success("Listagem de logs de entrada realizada com sucesso", lista);
    }

    @Transactional(readOnly = true)
    public ApiResponse<List<Log>> listarLogsSaida(){

        List<Log> lista = logsRepository.findByTipo(TipoLog.saida)
                .orElseThrow(() -> new NoSuchElementException("Nenhum log de saida encontrado"));

        return ApiResponse.success("Listagem de logs de saida realizada com sucesso", lista);
    }

    @Transactional(readOnly = true)
    public ApiResponse<List<Log>> listarLogsDescarte(){

        List<Log> lista = logsRepository.findByTipo(TipoLog.descarte)
                .orElseThrow(() -> new NoSuchElementException("Nenhum log de descarte encontrado"));

        return ApiResponse.success("Listagem de logs de descarte realizada com sucesso", lista);
    }

    @Transactional(readOnly = true)
    public ApiResponse<List<Log>> listarLogsAjuste(){

        List<Log> lista = logsRepository.findByTipo(TipoLog.ajuste)
                .orElseThrow(() -> new NoSuchElementException("Nenhum log de ajuste encontrado"));

        return ApiResponse.success("Listagem de logs de ajuste realizada com sucesso", lista);
    }

    @Transactional(readOnly = true)
    public ApiResponse<List<Log>> listarLogsErro(){

        List<Log> lista = logsRepository.findByTipo(TipoLog.erro)
                .orElseThrow(() -> new NoSuchElementException("Nenhum log de erro encontrado"));

        return ApiResponse.success("Listagem de logs de erro realizada com sucesso", lista);
    }

    @Transactional(readOnly = true)
    public ApiResponse<List<Log>> listarLogsIndefinido(){

        List<Log> lista = logsRepository.findByTipo(TipoLog.indefinido)
                .orElseThrow(() -> new NoSuchElementException("Nenhum log indefinido encontrado"));

        return ApiResponse.success("Listagem de logs indefinido realizada com sucesso", lista);
    }

    @Transactional(readOnly = true)
    public ApiResponse<List<Log>> listarLogsUltimas24h(){

        LocalDateTime dataLimite = LocalDateTime.now().minusHours(24);

        List<Log> lista = logsRepository.findByDataAfter(dataLimite)
                .orElseThrow(() -> new NoSuchElementException("Nenhum log nas ultimas 24h"));

        return ApiResponse.success("Listagem de logs das ultimas 24h realizada com sucesso", lista);
    }
}
