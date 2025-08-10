package br.com.gestao_obras.dto.request.crm_vendas;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPropostaComercialRequestDTO {

    private UUID id;

    @NotBlank(message = "A descrição do item é obrigatória.")
    private String descricao;

    @NotNull(message = "A quantidade é obrigatória.")
    @DecimalMin(value = "0.0", inclusive = false, message = "A quantidade deve ser maior que zero.")
    private BigDecimal quantidade;

    @NotNull(message = "O preço unitário é obrigatório.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O preço unitário deve ser maior que zero.")
    private BigDecimal precoUnitario;

    @NotNull(message = "O ID da proposta comercial é obrigatório.")
    private UUID propostaComercialId;
}
