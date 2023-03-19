package projects.dex.collecta.services;

import org.springframework.stereotype.Service;

import projects.dex.collecta.models.AuthRequest;
import projects.dex.collecta.models.AuthResponse;
import projects.dex.collecta.models.RegistRequest;

@Service
public interface AuthService {
    
    AuthResponse registration(RegistRequest registRequest);
    AuthResponse authenticate(AuthRequest authRequest);
}