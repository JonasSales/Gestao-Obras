package br.com.gestao_obras.dto.response.executaodeobras;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtapaObraResponseDTO {

    private UUID id;

    private String nome;

    private String descricao;

    private LocalDate dataInicioPrevista;

    private LocalDate dataFimPrevista;

    private LocalDate dataConclusaoReal;

    private Integer progressoPercentual;

    private StatusProgresso statusEtapaObra;

    private UUID obraId;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private String statusMensagem;

    private String mensagem;

    public enum StatusProgresso {
        NAO_INICIADA,
        EM_ANDAMENTO,
        CONCLUIDA,
        ATRASADA,
        BLOQUEADA
    }
}
