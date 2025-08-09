package br.com.gestao_obras.model.ExecucaoDeObras;

import br.com.gestao_obras.model.AutenticacaoEUsuarios.User;
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
public class DiarioObra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private LocalDate data;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @OneToMany(mappedBy = "diarioObra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FotoDiario> fotos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "obra_id")
    private Obra obra;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User autor;
}