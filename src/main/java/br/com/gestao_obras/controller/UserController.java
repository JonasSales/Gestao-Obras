package br.com.gestao_obras.controller;

import br.com.gestao_obras.dto.Response.UpdateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {


    @PutMapping()
    public ResponseEntity<UpdateResponse> updateUser(Authentication authentication) {
        System.out.println("Fast test to authentication" + authentication.getName());

        return  ResponseEntity.accepted().build();
    }
}
