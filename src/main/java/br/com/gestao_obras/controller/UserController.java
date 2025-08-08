package br.com.gestao_obras.controller;

import br.com.gestao_obras.dto.Request.UpdateResquest;
import br.com.gestao_obras.dto.Response.UserResponse;
import br.com.gestao_obras.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<UserResponse> getUser(@AuthenticationPrincipal UserDetails userDetails) {
        return userService.getProfile(userDetails);
    }

    @PutMapping()
    public ResponseEntity<UserResponse> updateUser(@AuthenticationPrincipal UserDetails userDetails,
                                                   @Valid @RequestBody UpdateResquest updateResquest) {
        return userService.update(userDetails, updateResquest);
    }
    @DeleteMapping
    public ResponseEntity<UserResponse> deleteUser(@AuthenticationPrincipal UserDetails userDetails) {
        return userService.delete(userDetails);
    }
}
