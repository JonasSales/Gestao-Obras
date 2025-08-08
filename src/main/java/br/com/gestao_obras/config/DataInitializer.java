package br.com.gestao_obras.config;

import br.com.gestao_obras.model.Role;
import br.com.gestao_obras.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initRoles(RoleRepository roleRepository) {
        return args -> {
            if (roleRepository.count() == 0) {
                roleRepository.save(new Role(null, Role.roleAuthority.ADMIN));
                roleRepository.save(new Role(null, Role.roleAuthority.USER));
                System.out.println("Roles padrão criadas!");
            }
        };
    }
}
