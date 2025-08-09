package br.com.gestao_obras.model.ComprasESuprimentos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal; // Importação correta
import java.time.LocalDate;  // Importação correta
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCotacao;

    private LocalDate dataCotacao; // Tipo alterado

    private BigDecimal totalCotacao; // Tipo alterado

    private Integer prazoEntregaDias;

    @ManyToOne
    @JoinColumn(name = "solicitacao_compra_id")
    private SolicitacaoCompra solicitacaoCompra;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;
}