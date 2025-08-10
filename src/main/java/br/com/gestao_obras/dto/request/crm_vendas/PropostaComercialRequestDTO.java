package br.com.gestao_obras.dto.request.crm_vendas;

import jakarta.validation.constraints.*;
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
public class PropostaComercialRequestDTO {

    private UUID id;

    @NotBlank(message = "O título da proposta é obrigatório.")
    private String titulo;

    @NotNull(message = "A data de criação é obrigatória.")
    @PastOrPresent(message = "A data de criação não pode ser no futuro.")
    private LocalDate dataCriacao;

    @NotNull(message = "A data de validade é obrigatória.")
    @FutureOrPresent(message = "A data de validade deve ser hoje ou no futuro.")
    private LocalDate dataValidade;

    @NotNull(message = "O valor total da proposta é obrigatório.")
    @PositiveOrZero(message = "O valor total da proposta não pode ser negativo.")
    private BigDecimal valorTotal;

    @NotNull(message = "O status da proposta é obrigatório.")
    private StatusProposta status;

    @NotNull(message = "O ID do cliente é obrigatório.")
    private UUID clienteId;

    private List<ItemPropostaComercialRequestDTO> itens;

    public enum StatusProposta {
        RASCUNHO,
        ENVIADO,
        ACEITA,
        REJEITADA
    }
}
