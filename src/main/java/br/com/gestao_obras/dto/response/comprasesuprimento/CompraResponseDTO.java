package br.com.gestao_obras.dto.response.comprasesuprimento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraResponseDTO {

    private UUID id;

    private LocalDate dataCompra;

    private BigDecimal valorCompra;

    private UUID fornecedorId;

    private UUID solicitacaoCompraId;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private String status;

    private String mensagem;
}
