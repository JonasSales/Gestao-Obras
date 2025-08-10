package br.com.gestao_obras.model.comprasesuprimentos;

import br.com.gestao_obras.model.autenticacaoeusuarios.User;
import br.com.gestao_obras.model.execucaodeobras.Obra;
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
public class SolicitacaoCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private LocalDate dataSolicitacao;

    @Enumerated(EnumType.STRING)
    private StatusSolicitacao statusSolicitacao;

    @OneToMany(mappedBy = "solicitacaoCompra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemSolicitacaoCompra> itens = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "obra_id")
    private Obra obra;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User solicitante;

    enum StatusSolicitacao {
        PENDENTE,
        APROVADO,
        REJEITADO,
        PROCESSADA
    }
}