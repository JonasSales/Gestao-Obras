package br.com.gestao_obras.dto.request.executaodeobras;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiarioObraRequestDTO {

    private UUID id;

    @NotNull(message = "A data do diário é obrigatória.")
    @PastOrPresent(message = "A data do diário não pode ser no futuro.")
    private LocalDate data;

    @NotBlank(message = "A descrição é obrigatória.")
    private String descricao;

    private List<FotoDiarioRequestDTO> fotos;

    @NotNull(message = "O ID da obra é obrigatório.")
    private UUID obraId;

    @NotNull(message = "O ID do autor é obrigatório.")
    private UUID autorId;
}
