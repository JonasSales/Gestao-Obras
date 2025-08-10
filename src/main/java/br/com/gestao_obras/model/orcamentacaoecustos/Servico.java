package br.com.gestao_obras.model.orcamentacaoecustos;

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
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Enumerated(EnumType.STRING)
    private UnidadeDeServico unidadeDeServico;

    private BigDecimal custo;

    public enum UnidadeDeServico {
        HORA,
        DIA,
        SEMANAL,
        MENSAL,
        FIXO
    }
}