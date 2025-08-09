package br.com.gestao_obras.model.Financeiro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime; // Usamos LocalDateTime para ter data e hora
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimentoCaixa { // Nome mais preciso

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private LocalDateTime dataMovimento; // Nome e tipo corrigidos

    @Enumerated(EnumType.STRING)
    private TipoMovimento tipoMovimento;

    private String descricao;

    private BigDecimal valor; // Tipo corrigido

    // Relacionamento único e direto com o Pagamento que gerou este movimento
    @OneToOne
    @JoinColumn(name = "pagamento_id")
    private Pagamento pagamento;

    public enum TipoMovimento {
        ENTRADA,
        SAIDA
    }
}