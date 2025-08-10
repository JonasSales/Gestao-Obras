package br.com.gestao_obras.dto.request.gestaodeprojetos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarcoProjetoRequestDTO {

    private UUID id;

    @NotBlank(message = "O nome do marco é obrigatório.")
    private String nome;

    @NotNull(message = "A data prevista de conclusão é obrigatória.")
    @FutureOrPresent(message = "A data prevista de conclusão deve ser hoje ou no futuro.")
    private LocalDate dataPrevisaoConclusao;

    private LocalDate conclusaoReal;

    @NotNull(message = "O status do marco é obrigatório.")
    private StatusMarco statusMarco;

    @NotNull(message = "O ID do projeto é obrigatório.")
    private UUID projetoId;

    public enum StatusMarco {
        PENDENTE,
        CONCLUIDO,
        ATRASADO
    }
}
