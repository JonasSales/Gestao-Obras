package br.com.gestao_obras.dto.request.comprasesuprimento;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CotacaoRequestDTO {

    private UUID id;

    @NotNull(message = "A data da cotação é obrigatória.")
    @FutureOrPresent(message = "A data da cotação não pode ser no passado.")
    private LocalDate dataCotacao;

    @NotNull(message = "O valor total da cotação é obrigatório.")
    @Positive(message = "O valor total deve ser positivo.")
    private BigDecimal totalCotacao;

    @NotNull(message = "O prazo de entrega é obrigatório.")
    @Positive(message = "O prazo de entrega deve ser um número positivo de dias.")
    private Integer prazoEntregaDias;

    @NotNull(message = "O ID da solicitação de compra é obrigatório.")
    private UUID solicitacaoCompraId;

    @NotNull(message = "O ID do fornecedor é obrigatório.")
    private UUID fornecedorId;
}
