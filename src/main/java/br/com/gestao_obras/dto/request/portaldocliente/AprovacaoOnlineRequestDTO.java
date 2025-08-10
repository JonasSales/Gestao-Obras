package br.com.gestao_obras.dto.request.portaldocliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AprovacaoOnlineRequestDTO {

    private UUID id;

    @NotBlank(message = "A descrição é obrigatória.")
    private String descricao;

    private LocalDateTime dataSolicitacao;

    private LocalDateTime dataResposta;

    @NotNull(message = "O status de aprovação é obrigatório.")
    private StatusAprovado statusAprovado;

    @NotNull(message = "O tipo do objeto a ser aprovado é obrigatório.")
    private TipoObjetoAprovacao tipoObjetoAprovacao;

    @NotNull(message = "O ID do objeto aprovado é obrigatório.")
    private UUID idObjetoAprovado;

    @NotNull(message = "O ID do cliente é obrigatório.")
    private UUID clienteId;

    @NotNull(message = "O ID do solicitante é obrigatório.")
    private UUID solicitanteId;

    public enum StatusAprovado {
        PENDENTE,
        APROVADO,
        REJEITADO
    }

    public enum TipoObjetoAprovacao {
        PROPOSTA_COMERCIAL,
        REVISAO_PROJETO,
        ETAPA_ORCAMENTO
    }
}
