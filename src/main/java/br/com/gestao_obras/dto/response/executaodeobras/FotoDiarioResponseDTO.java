package br.com.gestao_obras.dto.response.executaodeobras;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FotoDiarioResponseDTO {

    private UUID id;

    private String urlArquivo;

    private String legenda;

    private UUID diarioObraId;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private String statusMensagem;

    private String mensagem;
}
