package br.com.gestao_obras.model.GestaoDeProjetos;

import br.com.gestao_obras.model.AutenticacaoEUsuarios.User;
import br.com.gestao_obras.model.ExecucaoDeObras.Obra;
import br.com.gestao_obras.model.OrcamentacaoECustos.Orcamento;
import br.com.gestao_obras.model.crm_vendas.Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate; // Importação correta
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    @Enumerated(EnumType.STRING)
    private StatusProjeto statusProjeto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gerente_id")
    private User gerenteProjeto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MarcoProjeto> marcos = new ArrayList<>();

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RevisaoProjeto> revisoes = new ArrayList<>();

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tarefa> tarefas = new ArrayList<>();

    // Relacionamento 1-para-1 com Orçamento
    @OneToOne(mappedBy = "projeto", cascade = CascadeType.ALL)
    private Orcamento orcamento;

    // Relacionamento 1-para-1 com Obra
    @OneToOne(mappedBy = "projeto", cascade = CascadeType.ALL)
    private Obra obra;

    public enum StatusProjeto{
        PLANEJAMENTO,
        EM_EXECUCAO, // Adicionado para mais detalhe
        CONCLUIDO,
        CANCELADO
    }
}