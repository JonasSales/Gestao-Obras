package br.com.gestao_obras.model.ComprasESuprimentos;

import br.com.gestao_obras.model.Endereco;
import br.com.gestao_obras.model.OrcamentacaoECustos.Material;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal; // Recomendado para quantidades
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idEstoque;

    // Usar BigDecimal é mais seguro se a quantidade puder ser fracionada (ex: 1.5 kg)
    private BigDecimal quantidadeAtual;

    private BigDecimal quantidadeMinima;

    @ManyToOne
    @JoinColumn(name = "local_armazenagem_id") // Nome da coluna corrigido
    private Endereco localDeArmazenagem; // Nomenclatura corrigida

    // Este @ManyToOne permite que o mesmo material tenha estoque em vários locais
    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;
}