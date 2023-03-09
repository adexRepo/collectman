package projects.dex.collecta.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projects.dex.collecta.models.input.RegistrationRequest;

@RestController
@RequestMapping(path="api/v1")
public class AuthController {
    
    @PostMapping 
    public Boolean register(@RequestBody RegistrationRequest req){
        return true;
    }


}
