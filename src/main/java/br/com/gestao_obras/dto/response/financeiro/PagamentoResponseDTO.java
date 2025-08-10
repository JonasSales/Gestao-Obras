package br.com.gestao_obras.dto.response.financeiro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoResponseDTO {

    private UUID id;

    private BigDecimal valor;

    private LocalDateTime dataPagamento;

    private MetodoDePagamento metodoDePagamento;

    private StatusDePagamento statusDePagamento;

    private TipoMovimento tipoMovimento;

    private UUID contaAPagarId;

    private UUID contaAReceberId;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private String statusMensagem;

    private String mensagem;

    public enum MetodoDePagamento {
        PIX,
        BOLETO,
        CARTAO_DE_CREDITO,
        CARTAO_DE_DEBITO,
        TRANSFERENCIA_BANCARIA,
        DINHEIRO
    }

    public enum StatusDePagamento {
        PENDENTE,
        PAGO_PARCIALMENTE,
        PAGO,
        ATRASADO,
        CANCELADO
    }

    public enum TipoMovimento {
        ENTRADA,
        SAIDA
    }
}
