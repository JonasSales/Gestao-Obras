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
public class CotacaoResponseDTO {

    private UUID id;

    private LocalDate dataCotacao;

    private BigDecimal totalCotacao;

    private Integer prazoEntregaDias;

    private UUID solicitacaoCompraId;

    private UUID fornecedorId;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private String status;

    private String mensagem;
}
