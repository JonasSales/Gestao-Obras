package br.com.gestao_obras.service;

import br.com.gestao_obras.dto.Request.LoginRequest;
import br.com.gestao_obras.dto.Request.RegisterRequest;
import br.com.gestao_obras.dto.Response.LoginResponse;
import br.com.gestao_obras.dto.Response.UserRegisterResponse;
import br.com.gestao_obras.model.Role;
import br.com.gestao_obras.model.User;
import br.com.gestao_obras.repository.RoleRepository;
import br.com.gestao_obras.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final JwtUtil jwtUtil;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.jwtUtil = jwtUtil;
    }

    public ResponseEntity<LoginResponse> login(LoginRequest req) {
        User user = userRepository.findByEmail(req.email())
                .orElseThrow(() -> new RuntimeException("Credenciais inválidas"));
        if (!passwordEncoder.matches(req.password(), user.getPassword())) {
            throw new RuntimeException("Credenciais inválidas");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        return ResponseEntity.ok(new LoginResponse(token));
    }

    public ResponseEntity<UserRegisterResponse> registerUser(RegisterRequest registerRequest) {

        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        registerRequest.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        User user = new User(registerRequest);

        Role defaultRole = roleRepository.findByName(Role.roleAuthority.valueOf("ROLE_USER"))
                .orElseThrow(() -> new RuntimeException("Role não encontrada"));
        user.setRoles(Set.of(defaultRole));


        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.OK).body(new UserRegisterResponse(user));
    }


}
