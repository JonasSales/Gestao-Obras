package br.com.gestao_obras.dto.response.crm_vendas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPropostaComercialResponseDTO {

    private UUID id;

    private String descricao;

    private BigDecimal quantidade;

    private BigDecimal precoUnitario;

    private UUID propostaComercialId;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private String statusMensagem;

    private String mensagem;
}
