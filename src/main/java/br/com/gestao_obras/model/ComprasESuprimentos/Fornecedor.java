package br.com.gestao_obras.model.ComprasESuprimentos;

import br.com.gestao_obras.model.crm_vendas.Contato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
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

    @Column(unique = true) // Garante que o CNPJ seja único
    private String CNPJFornecedor;

    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contato> contatoes = new ArrayList<>(); // Relacionamento corrigido
}