package projects.dex.collectman.services.auth;

import projects.dex.collectman.models.AuthRequest;
import projects.dex.collectman.models.AuthResponse;
import projects.dex.collectman.models.RegistRequest;

public interface AuthService {
    AuthResponse registration(RegistRequest registRequest);
    AuthResponse authenticate(AuthRequest authRequest);
}