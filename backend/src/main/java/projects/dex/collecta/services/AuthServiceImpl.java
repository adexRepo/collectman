package projects.dex.collecta.services;

import projects.dex.collecta.models.AuthRegistrationRequest;

public class AuthServiceImpl implements AuthService  {

    @Override
    public boolean registration(AuthRegistrationRequest auth) {
        
        return true;
    }

    @Override
    public boolean login() {
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }
    
}
