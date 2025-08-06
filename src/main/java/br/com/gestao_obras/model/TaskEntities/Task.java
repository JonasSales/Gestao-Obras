package br.com.gestao_obras.model.TaskEntities;

import br.com.gestao_obras.model.ProjectEntities.Project;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDate prazo;
    private String status; // ex: PENDENTE, EM_ANDAMENTO, CONCLUIDA

    @ManyToOne
    private Project projeto;
}