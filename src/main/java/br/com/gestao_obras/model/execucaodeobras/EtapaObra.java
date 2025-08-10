package br.com.gestao_obras.model.execucaodeobras;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtapaObra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private LocalDate dataInicioPrevista;

    private LocalDate dataFimPrevista;

    private LocalDate dataConclusaoReal;

    private Integer progressoPercentual;

    @Enumerated(EnumType.STRING)
    private StatusProgresso statusEtapaObra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "obra_id")
    private Obra obra;

    public enum StatusProgresso {
        NAO_INICIADA,
        EM_ANDAMENTO,
        CONCLUIDA,
        ATRASADA,
        BLOQUEADA
    }
}