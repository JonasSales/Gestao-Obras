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
public class ServicoResponseDTO {

    private UUID id;

    private String nome;

    private String descricao;

    private UnidadeDeServico unidadeDeServico;

    private BigDecimal custo;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private String statusMensagem;

    private String mensagem;

    public enum UnidadeDeServico {
        HORA,
        DIA,
        SEMANAL,
        MENSAL,
        FIXO
    }
}
