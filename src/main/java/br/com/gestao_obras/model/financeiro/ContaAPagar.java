package br.com.gestao_obras.model.financeiro;

import br.com.gestao_obras.model.comprasesuprimentos.Fornecedor;
import br.com.gestao_obras.model.gestaodeprojetos.Projeto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaAPagar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String descricao;

    private BigDecimal valor;

    private LocalDate dataVencimento;
    private LocalDate dataPagamento;

    @Enumerated(EnumType.STRING)
    private StatusDePagamento statusDePagamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    @OneToMany(mappedBy = "contaAPagar", cascade = CascadeType.ALL)
    private List<Pagamento> pagamentos = new ArrayList<>();


    public enum StatusDePagamento {
        PENDENTE,
        PAGO_PARCIALMENTE,
        PAGO,
        ATRASADO,
        CANCELADO
    }
}