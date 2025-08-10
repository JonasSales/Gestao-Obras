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
public class MaterialRequestDTO {

    private UUID id;

    @NotBlank(message = "O nome do material é obrigatório.")
    private String nome;

    @NotNull(message = "A unidade de medida é obrigatória.")
    private UnidadeDeMedida unidadeDeMedida;

    @NotNull(message = "O custo unitário é obrigatório.")
    @Positive(message = "O custo unitário deve ser positivo.")
    private BigDecimal custoUnitario;

    private String descricao;

    public enum UnidadeDeMedida {
        METRO_QUADRADO,
        METRO_CUBICO,
        METRO_LINEAR,
        QUILOGRAMA,
        UNIDADE,
        LITRO
    }
}
