package br.com.gestao_obras.model.ComprasESuprimentos;

import br.com.gestao_obras.model.OrcamentacaoECustos.Material;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal; // Importação correta
import java.util.UUID;

// Nome da classe corrigido para maior clareza
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemSolicitacaoCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; // Nome do ID simplificado

    private BigDecimal quantidade; // Tipo de dado mais flexível

    @ManyToOne
    @JoinColumn(name = "solicitacao_compra_id") // Nome da coluna simplificado
    private SolicitacaoCompra solicitacaoCompra;

    @ManyToOne
    @JoinColumn(name = "material_id") // Nome da coluna simplificado
    private Material material;

    private String observacao;
}