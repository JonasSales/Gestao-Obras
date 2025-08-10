package br.com.gestao_obras.dto.request.comprasesuprimento;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitacaoCompraRequestDTO {

    private UUID id;

    @NotNull(message = "A data da solicitação é obrigatória.")
    @PastOrPresent(message = "A data da solicitação não pode estar no futuro.")
    private LocalDate dataSolicitacao;

    @NotNull(message = "O status da solicitação é obrigatório.")
    private StatusSolicitacao statusSolicitacao;

    private List<ItemSolicitacaoCompraRequestDTO> itens;

    @NotNull(message = "O ID da obra é obrigatório.")
    private UUID obraId;

    @NotNull(message = "O ID do solicitante é obrigatório.")
    private UUID solicitanteId;

    public enum StatusSolicitacao {
        PENDENTE,
        APROVADO,
        REJEITADO,
        PROCESSADA
    }
}
