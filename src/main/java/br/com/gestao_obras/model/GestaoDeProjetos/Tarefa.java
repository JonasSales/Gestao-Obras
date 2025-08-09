package br.com.gestao_obras.model.GestaoDeProjetos;

import br.com.gestao_obras.model.AutenticacaoEUsuarios.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private LocalDate dataInicio;

    private LocalDate dataPrevisao;

    private LocalDate conclusaoReal;

    @Enumerated(EnumType.STRING)
    private StatusTarefa statusTarefa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projeto_id")
    @JsonIgnore
    private Projeto projeto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_responsavel_id")
    @JsonIgnore
    private User usuarioResponsavel;

    // Relacionamento corrigido para uma lista de registros de tempo
    @OneToMany(mappedBy = "tarefa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegistroTempoTarefa> registrosDeTempo = new ArrayList<>();

    public enum StatusTarefa{
        A_FAZER,
        EM_PROCESSO,
        CONCLUIDA,
        BLOQUEADA // Convenção corrigida
    }

}