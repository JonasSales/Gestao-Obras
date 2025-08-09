package br.com.gestao_obras.model.OrcamentacaoECustos;

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
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; // Nome simplificado

    private String nome; // Nome simplificado

    @Enumerated(EnumType.STRING) // Boa prática
    private UnidadeDeMedida unidadeDeMedida;

    // Custo por m², kg, unidade, litro
    private BigDecimal custoUnitario; // Tipo corrigido e nome simplificado

    @Column(columnDefinition = "TEXT")
    private String descricao;

    public enum UnidadeDeMedida {
        METRO_QUADRADO,
        METRO_CUBICO, // Adicionei como sugestão
        METRO_LINEAR, // Adicionei como sugestão
        QUILOGRAMA,
        UNIDADE,
        LITRO
    }
}