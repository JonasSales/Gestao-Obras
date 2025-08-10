package br.com.gestao_obras.dto.response.crm_vendas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropostaComercialResponseDTO {

    private UUID id;

    private String titulo;

    private LocalDate dataCriacao;

    private LocalDate dataValidade;

    private BigDecimal valorTotal;

    private StatusProposta status;

    private UUID clienteId;

    private List<ItemPropostaComercialResponseDTO> itens;

    private LocalDateTime dataCriacaoSistema;

    private LocalDateTime dataAtualizacaoSistema;

    private String statusMensagem;

    private String mensagem;

    public enum StatusProposta {
        RASCUNHO,
        ENVIADO,
        ACEITA,
        REJEITADA
    }
}
