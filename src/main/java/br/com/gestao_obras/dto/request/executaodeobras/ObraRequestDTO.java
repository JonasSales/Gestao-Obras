package br.com.gestao_obras.dto.request.executaodeobras;

import br.com.gestao_obras.dto.request.comprasesuprimento.SolicitacaoCompraRequestDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObraRequestDTO {

    private UUID id;

    @NotBlank(message = "O nome da obra é obrigatório.")
    private String nome;

    @NotNull(message = "O ID do endereço é obrigatório.")
    private UUID enderecoId;

    private LocalDate dataInicioPrevista;

    private LocalDate dataFimPrevista;

    private LocalDate dataInicioReal;

    private LocalDate dataFimReal;

    @NotNull(message = "O status da obra é obrigatório.")
    private StatusProgresso statusObra;

    @NotNull(message = "O ID do projeto é obrigatório.")
    private UUID projetoId;

    private List<EtapaObraRequestDTO> etapas;

    private List<DiarioObraRequestDTO> diariosDeObra;

    private List<SolicitacaoCompraRequestDTO> solicitacoesDeCompra;

    public enum StatusProgresso {
        NAO_INICIADA,
        EM_ANDAMENTO,
        CONCLUIDA,
        ATRASADA,
        BLOQUEADA
    }
}