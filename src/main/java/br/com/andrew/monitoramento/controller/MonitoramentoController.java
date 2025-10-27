package br.com.andrew.monitoramento.controller;

import br.com.andrew.monitoramento.dto.ApiResponse;
import br.com.andrew.monitoramento.model.Log;
import br.com.andrew.monitoramento.service.MonitoramentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/monitoramento")
@RequiredArgsConstructor
public class MonitoramentoController {

    private final MonitoramentoService monitoramentoService;

    @GetMapping("/cadastro")
    public ApiResponse<List<Log>> listarLogsCadastro(){
        return monitoramentoService.listarLogsCadastro();
    }

    @GetMapping("/entrada")
    public ApiResponse<List<Log>> listarLogsEntrada(){
        return monitoramentoService.listarLogsEntrada();
    }

    @GetMapping("/saida")
    public ApiResponse<List<Log>> listarLogsSaida(){
        return monitoramentoService.listarLogsSaida();
    }

    @GetMapping("/descarte")
    public ApiResponse<List<Log>> listarLogsDescarte(){
        return monitoramentoService.listarLogsDescarte();
    }

    @GetMapping("/ajuste")
    public ApiResponse<List<Log>> listarLogsAjuste(){
        return monitoramentoService.listarLogsAjuste();
    }

    @GetMapping("/erro")
    public ApiResponse<List<Log>> listarLogsErro(){
        return monitoramentoService.listarLogsErro();
    }

    @GetMapping("/indefinido")
    public ApiResponse<List<Log>> listarLogsIndefinido(){
        return monitoramentoService.listarLogsIndefinido();
    }

    @GetMapping
    public ApiResponse<List<Log>> listarLogs24h(){
        return monitoramentoService.listarLogsUltimas24h();
    }
}
