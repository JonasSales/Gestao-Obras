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
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCompra;

    private LocalDate dataCompra; // Tipo alterado

    private BigDecimal valorCompra; // Tipo alterado

    @Enumerated(EnumType.STRING) // Boa prática: Mapeia o enum pelo nome, não pelo índice
    private StatusCompra statusCompra;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    @OneToOne
    @JoinColumn(name = "solicitacao_compra_id", unique = true)
    private SolicitacaoCompra solicitacaoCompra; // Classe e relacionamento corrigidos

    enum StatusCompra{
        EMITIDA,
        CONFIRMADA,
        ENTREGUE
    }
}