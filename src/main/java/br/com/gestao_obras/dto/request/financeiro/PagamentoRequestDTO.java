package br.com.gestao_obras.dto.request.financeiro;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoRequestDTO {

    private UUID id;

    @NotNull(message = "O valor do pagamento é obrigatório.")
    @Positive(message = "O valor do pagamento deve ser positivo.")
    private BigDecimal valor;

    @NotNull(message = "A data do pagamento é obrigatória.")
    private LocalDateTime dataPagamento;

    @NotNull(message = "O método de pagamento é obrigatório.")
    private MetodoDePagamento metodoDePagamento;

    private StatusDePagamento statusDePagamento;

    private TipoMovimento tipoMovimento;

    @NotNull(message = "O ID da conta a pagar é obrigatório.")
    private UUID contaAPagarId;

    private UUID contaAReceberId;

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
