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
public class ContaAPagarRequestDTO {

    private UUID id;

    @NotBlank(message = "A descrição da conta a pagar é obrigatória.")
    private String descricao;

    @NotNull(message = "O valor da conta a pagar é obrigatório.")
    @Positive(message = "O valor da conta a pagar deve ser positivo.")
    private BigDecimal valor;

    @NotNull(message = "A data de vencimento é obrigatória.")
    @FutureOrPresent(message = "A data de vencimento deve ser hoje ou no futuro.")
    private LocalDate dataVencimento;

    private LocalDate dataPagamento;

    @NotNull(message = "O status do pagamento é obrigatório.")
    private StatusDePagamento statusDePagamento;

    @NotNull(message = "O ID do fornecedor é obrigatório.")
    private UUID fornecedorId;

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
