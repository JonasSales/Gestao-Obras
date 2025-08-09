package br.com.gestao_obras.model.AutenticacaoEUsuarios;

import br.com.gestao_obras.dto.Request.RegisterRequest;
import br.com.gestao_obras.model.GestaoDeProjetos.RegistroTempoTarefa;
import br.com.gestao_obras.model.GestaoDeProjetos.Tarefa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true)
    private String email;

    private String password;
    private String firstName;
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany (mappedBy = "usuarioResponsavel")
    private List<Tarefa> tarefas = new ArrayList<>();

    @OneToMany(mappedBy = "usuarioQueRegistrouTempo")
    private List<RegistroTempoTarefa> registrosTempoTarefa = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toSet());
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    public User(RegisterRequest registerRequest) {
        this.email = registerRequest.getEmail();
        this.password = registerRequest.getPassword();
        this.firstName = registerRequest.getFirstName();
        this.lastName = registerRequest.getLastName();
    }
}