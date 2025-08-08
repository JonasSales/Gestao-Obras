package br.com.gestao_obras.controller;

import br.com.gestao_obras.model.ProjectEntities.Project;
import br.com.gestao_obras.repository.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectRepository repo;

    public ProjectController(ProjectRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Project criar(@RequestBody Project p) {
        return repo.save(p);
    }

    @GetMapping
    public List<Project> listar() {
        return repo.findAll();
    }
}
