package br.com.gestao_obras.model.gestaodeprojetos;

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
public class MarcoProjeto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    private LocalDate dataPrevisaoConclusao;
    private LocalDate conclusaoReal;

    @Enumerated(EnumType.STRING)
    private StatusMarco statusMarco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    public enum StatusMarco{
        PENDENTE,
        CONCLUIDO,
        ATRASADO
    }

}