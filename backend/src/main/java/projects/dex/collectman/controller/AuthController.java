package projects.dex.collectman.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import projects.dex.collectman.models.AuthRequest;
import projects.dex.collectman.models.AuthResponse;
import projects.dex.collectman.models.RegistRequest;
import projects.dex.collectman.services.auth.AuthService;

@RestController
@RequestMapping(path = "api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(path = "/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegistRequest request) {
        return ResponseEntity.ok(authService.registration(request));
    }

    @PostMapping(path = "/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest req) {
        return ResponseEntity.ok(authService.authenticate(req));

    }

}
