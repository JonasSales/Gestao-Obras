package br.com.gestao_obras.model.ExecucaoDeObras;

import br.com.gestao_obras.model.ComprasESuprimentos.SolicitacaoCompra;
import br.com.gestao_obras.model.Endereco; // Importe sua entidade Endereco
import br.com.gestao_obras.model.GestaoDeProjetos.Projeto;
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
public class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    private LocalDate dataInicioPrevista;
    private LocalDate dataFimPrevista;

    private LocalDate dataInicioReal;
    private LocalDate dataFimReal;

    @Enumerated(EnumType.STRING)
    private StatusProgresso statusObra; // Assumindo que StatusProgresso é um enum público

    // Relacionamento 1-para-1 com Projeto
    @OneToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    // Relacionamentos 1-para-N com as entidades filhas
    @OneToMany(mappedBy = "obra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EtapaObra> etapas = new ArrayList<>();

    @OneToMany(mappedBy = "obra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DiarioObra> diariosDeObra = new ArrayList<>();

    @OneToMany(mappedBy = "obra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SolicitacaoCompra> solicitacoesDeCompra = new ArrayList<>();
}