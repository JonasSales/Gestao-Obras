package br.com.gestao_obras.model.GestaoDeProjetos;

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
public class MarcoProjeto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; // Nome simplificado

    private String nome; // Nome simplificado

    private LocalDate dataPrevisaoConclusao; // Tipo corrigido

    private LocalDate conclusaoReal; // Tipo corrigido (pode ser nulo)

    @Enumerated(EnumType.STRING) // Boa prática
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