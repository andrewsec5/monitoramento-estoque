package br.com.andrew.monitoramento.model;

import br.com.andrew.monitoramento.config.enums.TipoLog;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "log")
public class Log {

    @Id
    private String id;

    private boolean sucesso;

    private String mensagem;

    private LocalDateTime data;

    private TipoLog tipo;

}
