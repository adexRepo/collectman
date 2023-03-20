package projects.dex.collecta.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import projects.dex.collecta.models.AuthRequest;
import projects.dex.collecta.models.AuthResponse;
import projects.dex.collecta.models.RegistRequest;
import projects.dex.collecta.services.impl.AuthServiceImpl;

@RestController
@RequestMapping(path = "api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServiceImpl authServiceImpl;

    @PostMapping(path = "/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegistRequest request) {
        return ResponseEntity.ok(authServiceImpl.registration(request));
    }

    @PostMapping(path = "/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest req) {
        return ResponseEntity.ok(authServiceImpl.authenticate(req));

    }

}
