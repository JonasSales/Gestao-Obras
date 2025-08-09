package br.com.gestao_obras.model.OrcamentacaoECustos;

import br.com.gestao_obras.model.GestaoDeProjetos.Projeto;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Orcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String titulo;

    private LocalDate dataCriacao;

    // Sugestão: Este campo deve ser calculado, não armazenado. Veja o método getValorEstimado()
    // private BigDecimal valorEstimado;

    private BigDecimal margemDeLucro; // Ex: 0.15 para 15%

    @Enumerated(EnumType.STRING)
    private StatusViabilidade statusViabilidade;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projeto_id")
    @JsonIgnore
    private Projeto projeto;

    @OneToMany(mappedBy = "orcamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemOrcamento> itemOrcamentos = new ArrayList<>();

    public enum StatusViabilidade {
        VIAVEL,
        INVIAVEL,
        ANALISE_PENDENTE
    }

    /**
     * Calcula o valor total estimado do orçamento somando os subtotais de todos os itens.
     * @return O valor total do orçamento.
     */
    @Transient
    public BigDecimal getValorEstimado() {
        return itemOrcamentos.stream()
                .map(ItemOrcamento::getSubtotal) // Usa o método que criamos em ItemOrcamento
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Calcula o valor final de venda (Valor Estimado + Margem de Lucro).
     * @return O valor final de venda.
     */
    @Transient
    public BigDecimal getValorFinalVenda() {
        BigDecimal valorEstimado = getValorEstimado();
        if (margemDeLucro != null) {
            BigDecimal lucro = valorEstimado.multiply(margemDeLucro);
            return valorEstimado.add(lucro);
        }
        return valorEstimado;
    }
}