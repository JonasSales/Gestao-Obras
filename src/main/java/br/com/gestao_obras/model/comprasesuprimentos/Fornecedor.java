package br.com.gestao_obras.model.comprasesuprimentos;

import br.com.gestao_obras.model.crm_vendas.Contato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idFornecedor;

    private String nomeFornecedor;

    @Column(unique = true)
    private String CNPJFornecedor;

    @OneToOne(mappedBy = "fornecedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Contato contatos;
}