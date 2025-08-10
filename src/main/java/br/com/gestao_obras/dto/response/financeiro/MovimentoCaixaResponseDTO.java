package br.com.gestao_obras.dto.response.financeiro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimentoCaixaResponseDTO {

    private UUID id;

    private LocalDateTime dataMovimento;

    private TipoMovimento tipoMovimento;

    private String descricao;

    private BigDecimal valor;

    private UUID pagamentoId;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private String statusMensagem;

    private String mensagem;

    public enum TipoMovimento {
        ENTRADA,
        SAIDA
    }
}
