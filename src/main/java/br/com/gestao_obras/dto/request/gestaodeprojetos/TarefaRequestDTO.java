package br.com.gestao_obras.dto.request.gestaodeprojetos;

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
public class TarefaRequestDTO {

    private UUID id;

    @NotBlank(message = "O título da tarefa é obrigatório.")
    private String titulo;

    private String descricao;

    private LocalDate dataInicio;

    private LocalDate dataPrevisao;

    private LocalDate conclusaoReal;

    @NotNull(message = "O status da tarefa é obrigatório.")
    private StatusTarefa statusTarefa;

    @NotNull(message = "O ID do projeto é obrigatório.")
    private UUID projetoId;

    @NotNull(message = "O ID do usuário responsável é obrigatório.")
    private UUID usuarioResponsavelId;

    public enum StatusTarefa {
        A_FAZER,
        EM_PROCESSO,
        CONCLUIDA,
        BLOQUEADA
    }
}
