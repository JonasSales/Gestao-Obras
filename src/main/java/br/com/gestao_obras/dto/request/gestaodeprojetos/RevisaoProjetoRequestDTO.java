package br.com.gestao_obras.dto.request.gestaodeprojetos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RevisaoProjetoRequestDTO {

    private UUID id;

    @NotNull(message = "A versão é obrigatória.")
    @Min(value = 1, message = "A versão deve ser maior ou igual a 1.")
    private Integer versao;

    @NotNull(message = "A data da revisão é obrigatória.")
    @PastOrPresent(message = "A data da revisão deve ser no passado ou presente.")
    private LocalDate data;

    private String alteracoes;

    @NotNull(message = "O ID do projeto é obrigatório.")
    private UUID projetoId;

    @NotNull(message = "O ID do revisor é obrigatório.")
    private UUID revisorId;
}
