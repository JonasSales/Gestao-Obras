package br.com.gestao_obras.model.GestaoDeProjetos;

import br.com.gestao_obras.model.AutenticacaoEUsuarios.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RevisaoProjeto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private Integer versao; // Tipo corrigido

    @Column(nullable = false)
    private LocalDate data; // Nome e tipo corrigidos

    @Column(columnDefinition = "TEXT")
    private String alteracoes; // Nome mais descritivo

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User revisor; // Nome mais claro
}