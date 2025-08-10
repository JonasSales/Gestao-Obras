package br.com.gestao_obras.dto.response.executaodeobras;

import br.com.gestao_obras.dto.response.comprasesuprimento.SolicitacaoCompraResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObraResponseDTO {

    private UUID id;

    private String nome;

    private UUID enderecoId;

    private LocalDate dataInicioPrevista;

    private LocalDate dataFimPrevista;

    private LocalDate dataInicioReal;

    private LocalDate dataFimReal;

    private StatusProgresso statusObra;

    private UUID projetoId;

    private List<EtapaObraResponseDTO> etapas;

    private List<DiarioObraResponseDTO> diariosDeObra;

    private List<SolicitacaoCompraResponseDTO> solicitacoesDeCompra;

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
