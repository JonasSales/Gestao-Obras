package br.com.gestao_obras.dto.response.gestaodeprojetos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RevisaoProjetoResponseDTO {

    private UUID id;

    private Integer versao;

    private LocalDate data;

    private String alteracoes;

    private UUID projetoId;

    private UUID revisorId;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private String statusMensagem;

    private String mensagem;
}
