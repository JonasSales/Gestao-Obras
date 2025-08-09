package br.com.gestao_obras.model.crm_vendas;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
// Importações comuns para JPA (Java Persistence API)
import br.com.gestao_obras.model.GestaoDeProjetos.Projeto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id // Chave primária
    @GeneratedValue(strategy = GenerationType.AUTO) // Gera o ID automaticamente
    private UUID id;

    private String nome;

    // Relação com Contatos (considerando que Contato também é uma entidade)
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contato> contatoes = new ArrayList<>();

    @Enumerated(EnumType.STRING) // Grava o nome do enum (LEAD, PROSPECT) no banco
    private TipoCliente tipoCliente;

    @Enumerated(EnumType.STRING) // Grava o nome do enum (NOVO, NEGOCIACAO) no banco
    private StatusCRM status;

    // RELACIONAMENTOS ADICIONADOS AQUI
    /**
     * Um Cliente (1) pode ter muitas Propostas Comerciais (N).
     * cascade = CascadeType.ALL: Se salvar/atualizar/remover um cliente, faz o mesmo com as propostas associadas.
     * orphanRemoval = true: Se uma proposta for removida da lista, ela é apagada do banco.
     */
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PropostaComercial> propostasComerciais = new ArrayList<>();

    /**
     * Um Cliente (1) pode ter muitos Projetos (N).
     */
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Projeto> projetos = new ArrayList<>();


    // Enums (como você já tinha)
    enum TipoCliente {
        LEAD,
        PROSPECT,
        CLIENTE,
    }

    enum StatusCRM{
        NOVO,
        NEGOCIACAO,
        ATIVO
    }

}