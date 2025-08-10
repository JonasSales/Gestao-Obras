package br.com.gestao_obras.dto.response.comprasesuprimento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstoqueResponseDTO {

    private UUID idEstoque;

    private BigDecimal quantidadeAtual;

    private BigDecimal quantidadeMinima;

    private UUID idEndereco;

    private UUID idMaterial;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private String status;

    private String mensagem;
}
