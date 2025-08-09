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
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome; // Nome simplificado

    @Column(columnDefinition = "TEXT")
    private String descricao; // Nome simplificado

    @Enumerated(EnumType.STRING) // Boa prática
    private UnidadeDeServico unidadeDeServico;

    private BigDecimal custo; // Tipo corrigido e nome simplificado

    public enum UnidadeDeServico {
        HORA,
        DIA,
        SEMANAL,
        MENSAL,
        FIXO // Adicionei como sugestão para serviços com preço fechado
    }
}