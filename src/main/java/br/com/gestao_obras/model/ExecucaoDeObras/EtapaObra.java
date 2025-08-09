package br.com.gestao_obras.model.ExecucaoDeObras;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate; // Importação correta
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtapaObra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; // Nome simplificado

    private String nome; // Nome simplificado

    @Column(columnDefinition = "TEXT")
    private String descricao; // Nome simplificado

    private LocalDate dataInicioPrevista; // Tipo corrigido

    private LocalDate dataFimPrevista; // Tipo corrigido

    private LocalDate dataConclusaoReal; // Tipo corrigido

    private Integer progressoPercentual; // Nome mais claro

    @Enumerated(EnumType.STRING) // Boa prática
    private StatusProgresso statusEtapaObra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "obra_id") // Coluna simplificada
    private Obra obra;

    // Enum que faltava foi adicionado aqui dentro
    public enum StatusProgresso {
        NAO_INICIADA,
        EM_ANDAMENTO,
        CONCLUIDA,
        ATRASADA,
        BLOQUEADA
    }
}