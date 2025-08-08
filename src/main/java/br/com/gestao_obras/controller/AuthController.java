package br.com.gestao_obras.controller;


import br.com.gestao_obras.dto.Request.LoginRequest;
import br.com.gestao_obras.dto.Request.RegisterRequest;
import br.com.gestao_obras.dto.Response.LoginResponse;
import br.com.gestao_obras.dto.Response.UserRegisterResponse;
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
    public ResponseEntity<UserRegisterResponse> register(@RequestBody @Valid RegisterRequest req) {
        return userService.registerUser(req);
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(LoginRequest req) {
        return userService.login(req);
    }

}
