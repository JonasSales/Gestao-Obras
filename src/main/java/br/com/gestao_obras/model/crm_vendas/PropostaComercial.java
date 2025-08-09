package br.com.gestao_obras.model.crm_vendas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropostaComercial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String titulo;

    private LocalDate dataCriacao;

    private LocalDate dataValidade;

    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    private StatusProposta status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "propostaComercial", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPropostaComercial> itens = new ArrayList<>();


    enum StatusProposta{
        RASCUNHO,
        ENVIADO,
        ACEITA,
        REJEITADA
    }
}