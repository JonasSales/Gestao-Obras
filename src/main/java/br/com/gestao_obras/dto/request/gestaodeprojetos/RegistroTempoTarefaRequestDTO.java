package br.com.gestao_obras.dto.request.gestaodeprojetos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroTempoTarefaRequestDTO {

    private UUID id;

    @NotNull(message = "O início do registro de tempo é obrigatório.")
    private LocalDateTime inicio;

    @NotNull(message = "O fim do registro de tempo é obrigatório.")
    private LocalDateTime fim;

    @NotNull(message = "O ID da tarefa é obrigatório.")
    private UUID tarefaId;

    @NotNull(message = "O ID do usuário que registrou o tempo é obrigatório.")
    private UUID usuarioQueRegistrouTempoId;
}
