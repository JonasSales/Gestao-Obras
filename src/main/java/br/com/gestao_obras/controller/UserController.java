package br.com.gestao_obras.controller;

import br.com.gestao_obras.dto.Response.UpdateResponse;
import br.com.gestao_obras.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {


    @PutMapping()
    public ResponseEntity<UpdateResponse> updateUser(@RequestBody User user) {

        return  ResponseEntity.ok(new UpdateResponse());
    }
}
