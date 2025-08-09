package br.com.gestao_obras.model.Financeiro;

import br.com.gestao_obras.model.ComprasESuprimentos.Fornecedor;
import br.com.gestao_obras.model.GestaoDeProjetos.Projeto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal; // Importação correta
import java.time.LocalDate;  // Importação correta
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaAPagar { // Nome no singular

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String descricao;

    private BigDecimal valor; // Tipo corrigido

    private LocalDate dataVencimento; // Tipo corrigido

    private LocalDate dataPagamento; // Tipo corrigido (pode ser nulo se não foi pago)

    @Enumerated(EnumType.STRING)
    private StatusDePagamento statusDePagamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fornecedor_id") // Coluna simplificada
    private Fornecedor fornecedor;

    // FK para PROJETO, opcional, se a conta for específica de um projeto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    // Relacionamento com pagamentos para esta conta
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