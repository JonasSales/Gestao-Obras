package br.com.gestao_obras.model.comprasesuprimentos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCompra;

    private LocalDate dataCompra;

    private BigDecimal valorCompra;

    @Enumerated(EnumType.STRING)
    private StatusCompra statusCompra;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    @OneToOne
    @JoinColumn(name = "solicitacao_compra_id", unique = true)
    private SolicitacaoCompra solicitacaoCompra;

    enum StatusCompra{
        EMITIDA,
        CONFIRMADA,
        ENTREGUE
    }
}