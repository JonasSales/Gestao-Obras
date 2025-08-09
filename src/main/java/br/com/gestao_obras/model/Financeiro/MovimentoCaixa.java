package br.com.gestao_obras.model.Financeiro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimentoCaixa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private LocalDateTime dataMovimento;

    @Enumerated(EnumType.STRING)
    private TipoMovimento tipoMovimento;

    private String descricao;

    private BigDecimal valor;

    @OneToOne
    @JoinColumn(name = "pagamento_id")
    private Pagamento pagamento;

    public enum TipoMovimento {
        ENTRADA,
        SAIDA
    }
}