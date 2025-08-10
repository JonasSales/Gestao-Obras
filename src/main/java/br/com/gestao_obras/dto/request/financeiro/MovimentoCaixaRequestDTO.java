package br.com.gestao_obras.dto.request.financeiro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimentoCaixaRequestDTO {

    private UUID id;

    @NotNull(message = "A data do movimento é obrigatória.")
    private LocalDateTime dataMovimento;

    @NotNull(message = "O tipo do movimento é obrigatório.")
    private TipoMovimento tipoMovimento;

    @NotBlank(message = "A descrição do movimento é obrigatória.")
    private String descricao;

    @NotNull(message = "O valor do movimento é obrigatório.")
    @Positive(message = "O valor do movimento deve ser positivo.")
    private BigDecimal valor;

    @NotNull(message = "O ID do pagamento é obrigatório.")
    private UUID pagamentoId;

    public enum TipoMovimento {
        ENTRADA,
        SAIDA
    }
}
