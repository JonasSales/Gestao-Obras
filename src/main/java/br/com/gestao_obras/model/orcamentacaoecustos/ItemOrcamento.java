package br.com.gestao_obras.model.orcamentacaoecustos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemOrcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String descricao;

    private BigDecimal quantidade;

    private BigDecimal valorUnitario;

    @Enumerated(EnumType.STRING)
    private TipoItem tipoItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orcamento_id")
    @JsonIgnore
    private Orcamento orcamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "material_id")
    @JsonIgnore
    private Material material;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servico_id")
    @JsonIgnore
    private Servico servico;

    public enum TipoItem {
        MATERIAL,
        SERVICO
    }

    @Transient
    public BigDecimal getSubtotal() {
        if (quantidade == null || valorUnitario == null) {
            return BigDecimal.ZERO;
        }
        return quantidade.multiply(valorUnitario);
    }
}