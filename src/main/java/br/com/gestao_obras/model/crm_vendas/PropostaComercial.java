package br.com.gestao_obras.model.crm_vendas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal; // Importação correta
import java.time.LocalDate;  // Importação correta
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

    // Relacionamento com os itens da proposta
    @OneToMany(mappedBy = "propostaComercial", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPropostaComercial> itens = new ArrayList<>();


    enum StatusProposta{
        RASCUNHO,
        ENVIADO,
        ACEITA, // Alterado de REGISTRADO para um termo mais claro no contexto da proposta
        REJEITADA // Alterado para manter o padrão
    }
}