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
public class ItemCompraRequestDTO {

    private UUID idItemCompra;

    @NotNull(message = "A quantidade é obrigatória.")
    @DecimalMin(value = "0.0", inclusive = false, message = "A quantidade deve ser maior que zero.")
    private BigDecimal quantidade;

    @NotNull(message = "O preço unitário é obrigatório.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O preço unitário deve ser maior que zero.")
    private BigDecimal precoUnitario;

    @NotNull(message = "O ID da compra é obrigatório.")
    private UUID compraId;

    @NotNull(message = "O ID do material é obrigatório.")
    private UUID materialId;
}
