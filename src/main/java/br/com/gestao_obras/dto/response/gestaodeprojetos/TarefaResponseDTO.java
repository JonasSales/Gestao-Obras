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
public class TarefaResponseDTO {

    private UUID id;

    private String titulo;

    private String descricao;

    private LocalDate dataInicio;

    private LocalDate dataPrevisao;

    private LocalDate conclusaoReal;

    private StatusTarefa statusTarefa;

    private UUID projetoId;

    private UUID usuarioResponsavelId;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private String statusMensagem;

    private String mensagem;

    public enum StatusTarefa {
        A_FAZER,
        EM_PROCESSO,
        CONCLUIDA,
        BLOQUEADA
    }
}
