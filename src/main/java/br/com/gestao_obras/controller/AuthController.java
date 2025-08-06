package br.com.gestao_obras.controller;


import br.com.gestao_obras.model.Role;
import br.com.gestao_obras.model.User;
import br.com.gestao_obras.repository.RoleRepository;
import br.com.gestao_obras.repository.UserRepository;
import br.com.gestao_obras.service.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepo,
                          RoleRepository roleRepo,
                          PasswordEncoder encoder,
                          JwtUtil jwtUtil) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public String register(@RequestBody @Valid RegisterRequest req) {
        if (userRepo.findByEmail(req.email).isPresent()) {
            return "Usuário já existe";
        }

        User u = new User();
        u.setEmail(req.email());
        u.setPassword(encoder.encode(req.password()));
        u.setFirstName(req.firstName);
        u.setLastName(req.lastName);


        Role role = roleRepo.findByName(Role.roleAuthority.valueOf("ROLE_USER"))
                .orElseThrow(() -> new RuntimeException("Role not found"));
        u.setRoles(Set.of(role));

        userRepo.save(u);
        return "Registrado";
    }


    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest req) {
        User u = userRepo.findByEmail(req.email)
                .orElseThrow(() -> new RuntimeException("Credenciais inválidas"));
        if (!encoder.matches(req.password, u.getPassword())) {
            throw new RuntimeException("Credenciais inválidas");
        }
        String token = jwtUtil.generateToken(u.getUsername());
        return new TokenResponse(token);
    }


    record RegisterRequest(String email, String password, String firstName, String lastName) {}
    record LoginRequest(String email, String password) {}
    record TokenResponse(String accessToken) {}
}
