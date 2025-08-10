package br.com.gestao_obras.dto.response.gestaodeprojetos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroTempoTarefaResponseDTO {

    private UUID id;

    private LocalDateTime inicio;

    private LocalDateTime fim;

    private UUID tarefaId;

    private UUID usuarioQueRegistrouTempoId;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private String statusMensagem;

    private String mensagem;
}
