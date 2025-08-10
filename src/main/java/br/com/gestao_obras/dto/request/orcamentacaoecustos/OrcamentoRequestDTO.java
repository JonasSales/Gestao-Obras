package br.com.gestao_obras.dto.request.orcamentacaoecustos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrcamentoRequestDTO {

    private UUID id;

    @NotBlank(message = "O título do orçamento é obrigatório.")
    private String titulo;

    private LocalDate dataCriacao;

    private BigDecimal margemDeLucro;

    @NotNull(message = "O status de viabilidade é obrigatório.")
    private StatusViabilidade statusViabilidade;

    @NotNull(message = "O ID do projeto é obrigatório.")
    private UUID projetoId;

    private List<ItemOrcamentoRequestDTO> itemOrcamentos;

    public enum StatusViabilidade {
        VIAVEL,
        INVIAVEL,
        ANALISE_PENDENTE
    }
}
