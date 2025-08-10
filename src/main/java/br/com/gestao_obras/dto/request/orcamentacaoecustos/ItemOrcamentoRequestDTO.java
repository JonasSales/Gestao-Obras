package br.com.gestao_obras.dto.request.orcamentacaoecustos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemOrcamentoRequestDTO {

    private UUID id;

    @NotBlank(message = "A descrição do item é obrigatória.")
    private String descricao;

    @NotNull(message = "A quantidade é obrigatória.")
    @Positive(message = "A quantidade deve ser positiva.")
    private BigDecimal quantidade;

    @NotNull(message = "O valor unitário é obrigatório.")
    @Positive(message = "O valor unitário deve ser positivo.")
    private BigDecimal valorUnitario;

    @NotNull(message = "O tipo do item é obrigatório.")
    private TipoItem tipoItem;

    @NotNull(message = "O ID do orçamento é obrigatório.")
    private UUID orcamentoId;


    private UUID materialId; // Pode ser nulo se for SERVICO

    private UUID servicoId; // Pode ser nulo se for MATERIAL

    public enum TipoItem {
        MATERIAL,
        SERVICO
    }
}
