package br.com.andrew.monitoramento.mapper;

import br.com.andrew.monitoramento.config.enums.TipoLog;
import br.com.andrew.monitoramento.dto.LogRecord;
import br.com.andrew.monitoramento.model.Log;
import org.springframework.stereotype.Component;

@Component
public class LogMapper {

    public Log toEntity(LogRecord logRecord){

        boolean sucesso;
        TipoLog tipo;

        sucesso = logRecord.tipo().equals("SUCESSO");

        if(logRecord.mensagem().matches("(?i).*\\bentrada\\b.*")) tipo = TipoLog.entrada;
        else if(logRecord.mensagem().matches("(?i).*\\bsaida\\b.*")) tipo = TipoLog.saida;
        else if(logRecord.mensagem().matches("(?i).*\\bcadastrado\\b.*")) tipo = TipoLog.cadastro;
        else if(logRecord.mensagem().matches("(?i).*\\bajuste\\b.*")) tipo = TipoLog.ajuste;
        else if(logRecord.mensagem().matches("(?i).*\\bdescartado\\b.*")) tipo = TipoLog.descarte;
        else if(logRecord.mensagem().matches("(?i).*\\bcontagem\\b.*")) tipo = TipoLog.contagem;
        else if(logRecord.mensagem().matches("(?i).*\\bvalidade\\b.*")) tipo = TipoLog.verificacaoValidade;
        else if(!sucesso) tipo = TipoLog.erro;
        else tipo = TipoLog.indefinido;

        return Log.builder()
                .sucesso(sucesso)
                .data(logRecord.dataHora())
                .mensagem(logRecord.mensagem())
                .tipo(tipo)
                .build();
    }
}
