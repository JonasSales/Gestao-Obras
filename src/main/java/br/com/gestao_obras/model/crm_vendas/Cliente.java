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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contato> contatoes = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private TipoCliente tipoCliente;

    @Enumerated(EnumType.STRING)
    private StatusCRM status;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PropostaComercial> propostasComerciais = new ArrayList<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Projeto> projetos = new ArrayList<>();



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