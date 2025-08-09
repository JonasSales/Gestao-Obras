package br.com.gestao_obras.model.Financeiro;

import br.com.gestao_obras.model.GestaoDeProjetos.Projeto;
import br.com.gestao_obras.model.crm_vendas.Cliente;
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
public class ContaAReceber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; // Nome simplificado

    private String descricao;

    private BigDecimal valor; // Tipo corrigido

    private LocalDate dataVencimento; // Tipo corrigido

    private LocalDate dataRecebimento; // Nome mais específico e tipo corrigido

    @Enumerated(EnumType.STRING)
    private StatusDePagamento statusDePagamento; // Recomendo criar este enum em um arquivo separado

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    // Relacionamento com os pagamentos recebidos para esta conta
    @OneToMany(mappedBy = "contaAReceber", cascade = CascadeType.ALL)
    private List<Pagamento> pagamentos = new ArrayList<>();

    /*
     * Enum StatusDePagamento
     * (Idealmente, este enum deve estar em seu próprio arquivo para ser reutilizado)
     */
    public enum StatusDePagamento {
        PENDENTE,
        PAGO_PARCIALMENTE,
        PAGO,
        ATRASADO,
        CANCELADO
    }
}