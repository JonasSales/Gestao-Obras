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
public class ItemCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idItemCompra;

    private BigDecimal quantidade;

    private BigDecimal precoUnitario;

    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;
}