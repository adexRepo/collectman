package projects.dex.collecta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projects.dex.collecta.models.AuthRegistrationRequest;
import projects.dex.collecta.services.AuthServiceImpl;

@RestController
@RequestMapping(path="api/v1")
public class AuthController {

    @Autowired
    AuthServiceImpl AuthServiceImpl;
    
    @PostMapping(path="registration")
    public Boolean register(@RequestBody AuthRegistrationRequest req){
        return AuthServiceImpl.registration(req);
    }


}
