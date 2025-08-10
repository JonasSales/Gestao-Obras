package br.com.gestao_obras.dto.response.orcamentacaoecustos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemOrcamentoResponseDTO {

    private UUID id;

    private String descricao;

    private BigDecimal quantidade;

    private BigDecimal valorUnitario;

    private TipoItem tipoItem;

    private UUID orcamentoId;

    private UUID materialId;

    private UUID servicoId;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private String statusMensagem;

    private String mensagem;

    public enum TipoItem {
        MATERIAL,
        SERVICO
    }
}
