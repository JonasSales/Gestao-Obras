package br.com.gestao_obras.dto.request.comprasesuprimento;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
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
public class CompraRequestDTO {

    private UUID id;

    @NotNull(message = "A data da compra é obrigatória.")
    @PastOrPresent(message = "A data da compra não pode ser no futuro.")
    private LocalDate dataCompra;

    @NotNull(message = "O valor da compra é obrigatório.")
    @Positive(message = "O valor da compra deve ser positivo.")
    private BigDecimal valorCompra;

    @NotNull(message = "O ID do fornecedor é obrigatório.")
    private UUID fornecedorId;

    @NotNull(message = "O ID da solicitação de compra é obrigatório.")
    private UUID solicitacaoCompraId;
}
