package br.com.gestao_obras.repository;


import br.com.gestao_obras.model.ProjectEntities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID> {
}
