package br.com.gestao_obras.dto.response.executaodeobras;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiarioObraResponseDTO {

    private UUID id;

    private LocalDate data;

    private String descricao;

    private List<FotoDiarioResponseDTO> fotos;

    private UUID obraId;

    private UUID autorId;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private String statusMensagem;

    private String mensagem;
}
