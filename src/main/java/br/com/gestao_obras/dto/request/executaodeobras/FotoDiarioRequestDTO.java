package br.com.gestao_obras.dto.request.executaodeobras;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FotoDiarioRequestDTO {

    private UUID id;

    @NotBlank(message = "A URL do arquivo é obrigatória.")
    private String urlArquivo;

    private String legenda;

    @NotNull(message = "O ID do diário de obra é obrigatório.")
    private UUID diarioObraId;
}
