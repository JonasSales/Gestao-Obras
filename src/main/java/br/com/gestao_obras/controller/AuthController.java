package br.com.gestao_obras.controller;


import br.com.gestao_obras.dto.request.LoginRequest;
import br.com.gestao_obras.dto.request.RegisterRequest;
import br.com.gestao_obras.dto.response.LoginResponse;
import br.com.gestao_obras.dto.response.UserResponse;
import br.com.gestao_obras.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody @Valid RegisterRequest req) {
        return userService.registerAccount(req);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest req) {
        return userService.login(req);
    }
}
