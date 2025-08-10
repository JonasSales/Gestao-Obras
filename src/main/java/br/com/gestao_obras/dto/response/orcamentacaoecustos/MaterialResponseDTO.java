package br.com.gestao_obras.dto.response.orcamentacaoecustos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialResponseDTO {

    private UUID id;

    private String nome;

    private UnidadeDeMedida unidadeDeMedida;

    private BigDecimal custoUnitario;

    private String descricao;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private String statusMensagem;

    private String mensagem;

    public enum UnidadeDeMedida {
        METRO_QUADRADO,
        METRO_CUBICO,
        METRO_LINEAR,
        QUILOGRAMA,
        UNIDADE,
        LITRO
    }
}
