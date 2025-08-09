package br.com.gestao_obras.model.ComprasESuprimentos;

import br.com.gestao_obras.model.AutenticacaoEUsuarios.User;
import br.com.gestao_obras.model.ExecucaoDeObras.Obra;
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
public class SolicitacaoCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; // Nome simplificado

    private LocalDate dataSolicitacao; // Nome e tipo corrigidos

    @Enumerated(EnumType.STRING) // Boa prática
    private StatusSolicitacao statusSolicitacao;

    @OneToMany(mappedBy = "solicitacaoCompra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemSolicitacaoCompra> itens = new ArrayList<>(); // Lista de itens adicionada

    @ManyToOne
    @JoinColumn(name = "obra_id") // Coluna simplificada
    private Obra obra;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User solicitante; // Renomeado "user" para "solicitante" para mais clareza

    enum StatusSolicitacao {
        PENDENTE,
        APROVADO,
        REJEITADO,
        PROCESSADA
    }
}