package br.com.gestao_obras.model.ComprasESuprimentos;

import br.com.gestao_obras.model.Endereco;
import br.com.gestao_obras.model.OrcamentacaoECustos.Material;
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
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idEstoque;


    private BigDecimal quantidadeAtual;

    private BigDecimal quantidadeMinima;

    @ManyToOne
    @JoinColumn(name = "local_armazenagem_id")
    private Endereco localDeArmazenagem;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;
}