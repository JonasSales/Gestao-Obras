package br.com.gestao_obras.model.OrcamentacaoECustos;

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
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private UnidadeDeMedida unidadeDeMedida;

    private BigDecimal custoUnitario;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    public enum UnidadeDeMedida {
        METRO_QUADRADO,
        METRO_CUBICO,
        METRO_LINEAR,
        QUILOGRAMA,
        UNIDADE,
        LITRO
    }
}