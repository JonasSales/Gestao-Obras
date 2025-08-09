package br.com.gestao_obras.model.Financeiro;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private LocalDateTime dataPagamento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MetodoDePagamento metodoDePagamento;

    @Enumerated(EnumType.STRING)
    private StatusDePagamento statusDePagamento;

    @Enumerated(EnumType.STRING)
    private TipoMovimento tipoMovimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conta_a_pagar_id")
    @JsonIgnore
    private ContaAPagar contaAPagar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conta_a_receber_id")
    @JsonIgnore
    private ContaAReceber contaAReceber;

    @OneToOne(mappedBy = "pagamento", cascade = CascadeType.ALL)
    private MovimentoCaixa movimentoCaixa;

    public enum MetodoDePagamento {
        PIX,
        BOLETO,
        CARTAO_DE_CREDITO,
        CARTAO_DE_DEBITO,
        TRANSFERENCIA_BANCARIA,
        DINHEIRO
    }
}