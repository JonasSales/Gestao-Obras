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
public class ServicoRequestDTO {

    private UUID id;

    @NotBlank(message = "O nome do serviço é obrigatório.")
    private String nome;

    private String descricao;

    @NotNull(message = "A unidade do serviço é obrigatória.")
    private UnidadeDeServico unidadeDeServico;

    @NotNull(message = "O custo do serviço é obrigatório.")
    @Positive(message = "O custo do serviço deve ser positivo.")
    private BigDecimal custo;

    public enum UnidadeDeServico {
        HORA,
        DIA,
        SEMANAL,
        MENSAL,
        FIXO
    }
}
