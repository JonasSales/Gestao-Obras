package br.com.gestao_obras.dto.request.financeiro;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContaAReceberRequestDTO {

    private UUID id;

    @NotBlank(message = "A descrição da conta a receber é obrigatória.")
    private String descricao;

    @NotNull(message = "O valor da conta a receber é obrigatório.")
    @Positive(message = "O valor da conta a receber deve ser positivo.")
    private BigDecimal valor;

    @NotNull(message = "A data de vencimento é obrigatória.")
    @FutureOrPresent(message = "A data de vencimento deve ser hoje ou no futuro.")
    private LocalDate dataVencimento;

    private LocalDate dataRecebimento;
    @NotNull(message = "O status do pagamento é obrigatório.")
    private StatusDePagamento statusDePagamento;

    @NotNull(message = "O ID do cliente é obrigatório.")
    private UUID clienteId;

    @NotNull(message = "O ID do projeto é obrigatório.")
    private UUID projetoId;

    public enum StatusDePagamento {
        PENDENTE,
        PAGO_PARCIALMENTE,
        PAGO,
        ATRASADO,
        CANCELADO
    }
}

