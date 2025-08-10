package br.com.gestao_obras.model.comprasesuprimentos;

import br.com.gestao_obras.model.orcamentacaoecustos.Material;
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
public class ItemSolicitacaoCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private BigDecimal quantidade;

    @ManyToOne
    @JoinColumn(name = "solicitacao_compra_id")
    private SolicitacaoCompra solicitacaoCompra;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    private String observacao;
}