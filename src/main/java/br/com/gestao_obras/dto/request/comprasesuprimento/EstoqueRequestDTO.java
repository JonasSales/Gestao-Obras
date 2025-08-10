package br.com.gestao_obras.dto.request.comprasesuprimento;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class EstoqueRequestDTO {

    private UUID idEstoque;

    @NotNull(message = "A quantidade atual é obrigatória.")
    @DecimalMin(value = "0.0", inclusive = false, message = "A quantidade atual deve ser maior que zero.")
    private BigDecimal quantidadeAtual;

    @NotNull(message = "A quantidade mínima do estoque é obrigatória.")
    @DecimalMin(value = "0.0", inclusive = false, message = "A quantidade mínima deve ser maior que zero.")
    private BigDecimal quantidadeMinima;

    @NotNull(message = "O ID do endereço é obrigatório.")
    private UUID idEndereco;

    @NotNull(message = "O ID do material é obrigatório.")
    private UUID idMaterial;
}
