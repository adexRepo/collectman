package projects.dex.collecta.services;

import projects.dex.collecta.models.AuthRegistrationRequest;

public interface AuthService {
    
    boolean registration(AuthRegistrationRequest auth);

    boolean login();
}