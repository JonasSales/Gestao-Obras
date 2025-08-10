package br.com.gestao_obras.dto.request.comprasesuprimento;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemSolicitacaoCompraRequestDTO {

    private UUID id;

    @NotNull(message = "A quantidade é obrigatória.")
    @DecimalMin(value = "0.0", inclusive = false, message = "A quantidade deve ser maior que zero.")
    private BigDecimal quantidade;

    @NotNull(message = "O ID da solicitação de compra é obrigatório.")
    private UUID solicitacaoCompraId;

    @NotNull(message = "O ID do material é obrigatório.")
    private UUID materialId;

    private String observacao; // Opcional
}
