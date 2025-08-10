package br.com.gestao_obras.model.orcamentacaoecustos;

import br.com.gestao_obras.model.gestaodeprojetos.Projeto;
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

    private BigDecimal margemDeLucro;

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

    @Transient
    public BigDecimal getValorEstimado() {
        return itemOrcamentos.stream()
                .map(ItemOrcamento::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


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