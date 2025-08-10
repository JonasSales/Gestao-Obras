package br.com.gestao_obras.dto.request.executaodeobras;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtapaObraRequestDTO {

    private UUID id;

    @NotBlank(message = "O nome da etapa é obrigatório.")
    private String nome;

    private String descricao;

    private LocalDate dataInicioPrevista;

    private LocalDate dataFimPrevista;

    private LocalDate dataConclusaoReal;

    @Min(value = 0, message = "O progresso percentual não pode ser menor que 0.")
    @Max(value = 100, message = "O progresso percentual não pode ser maior que 100.")
    private Integer progressoPercentual;

    @NotNull(message = "O status da etapa é obrigatório.")
    private StatusProgresso statusEtapaObra;

    @NotNull(message = "O ID da obra é obrigatório.")
    private UUID obraId;

    public enum StatusProgresso {
        NAO_INICIADA,
        EM_ANDAMENTO,
        CONCLUIDA,
        ATRASADA,
        BLOQUEADA
    }
}