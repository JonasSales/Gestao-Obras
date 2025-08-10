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
public class ItemCompraResponseDTO {

    private UUID idItemCompra;

    private BigDecimal quantidade;

    private BigDecimal precoUnitario;

    private UUID compraId;

    private UUID materialId;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private String status;

    private String mensagem;
}
