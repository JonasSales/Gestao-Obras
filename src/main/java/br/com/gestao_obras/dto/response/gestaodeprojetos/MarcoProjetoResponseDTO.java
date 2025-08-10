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
public class MarcoProjetoResponseDTO {

    private UUID id;

    private String nome;

    private LocalDate dataPrevisaoConclusao;

    private LocalDate conclusaoReal;

    private StatusMarco statusMarco;

    private UUID projetoId;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private String statusMensagem;

    private String mensagem;

    public enum StatusMarco {
        PENDENTE,
        CONCLUIDO,
        ATRASADO
    }
}
