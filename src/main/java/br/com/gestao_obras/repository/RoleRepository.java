package br.com.gestao_obras.repository;

import br.com.gestao_obras.model.autenticacaoeusuarios.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(Role.roleAuthority name);


}
