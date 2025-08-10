package br.com.gestao_obras.dto.response.portaldocliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AprovacaoOnlineResponseDTO {

    private UUID id;

    private String descricao;

    private LocalDateTime dataSolicitacao;

    private LocalDateTime dataResposta;

    private StatusAprovado statusAprovado;

    private TipoObjetoAprovacao tipoObjetoAprovacao;

    private UUID idObjetoAprovado;

    private UUID clienteId;

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
