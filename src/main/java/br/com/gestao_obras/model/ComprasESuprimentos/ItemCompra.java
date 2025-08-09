package br.com.gestao_obras.model.ComprasESuprimentos;

import br.com.gestao_obras.model.OrcamentacaoECustos.Material;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal; // Importação correta
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idItemCompra;

    private BigDecimal quantidade; // Tipo alterado para mais flexibilidade

    private BigDecimal precoUnitario; // Tipo alterado para precisão monetária

    @ManyToOne
    @JoinColumn(name = "compra_id") // Nome da coluna simplificado
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "material_id") // Nome da coluna simplificado
    private Material material;
}