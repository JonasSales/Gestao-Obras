package br.com.gestao_obras.dto.response.orcamentacaoecustos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrcamentoResponseDTO {

    private UUID id;

    private String titulo;

    private LocalDate dataCriacao;

    private BigDecimal margemDeLucro;

    private StatusViabilidade statusViabilidade;

    private UUID projetoId;

    private List<ItemOrcamentoResponseDTO> itemOrcamentos;

    private LocalDateTime dataCriacaoRegistro;

    private LocalDateTime dataAtualizacao;

    private String statusMensagem;

    private String mensagem;

    public enum StatusViabilidade {
        VIAVEL,
        INVIAVEL,
        ANALISE_PENDENTE
    }
}
