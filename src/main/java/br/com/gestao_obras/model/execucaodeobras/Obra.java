package br.com.gestao_obras.model.execucaodeobras;

import br.com.gestao_obras.model.comprasesuprimentos.SolicitacaoCompra;
import br.com.gestao_obras.model.Endereco; // Importe sua entidade Endereco
import br.com.gestao_obras.model.gestaodeprojetos.Projeto;
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
    private StatusProgresso statusObra;

    @OneToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    @OneToMany(mappedBy = "obra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EtapaObra> etapas = new ArrayList<>();

    @OneToMany(mappedBy = "obra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DiarioObra> diariosDeObra = new ArrayList<>();

    @OneToMany(mappedBy = "obra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SolicitacaoCompra> solicitacoesDeCompra = new ArrayList<>();
}