package br.com.gestao_obras.dto.response.comprasesuprimento;

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
public class SolicitacaoCompraResponseDTO {

    private UUID id;

    private LocalDate dataSolicitacao;

    private StatusSolicitacao statusSolicitacao;

    private List<ItemSolicitacaoCompraResponseDTO> itens;

    private UUID obraId;

    private UUID solicitanteId;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private String status;

    private String mensagem;

    public enum StatusSolicitacao {
        PENDENTE,
        APROVADO,
        REJEITADO,
        PROCESSADA
    }
}
