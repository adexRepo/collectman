package projects.dex.collecta.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projects.dex.collecta.models.dto.UserDto;
import projects.dex.collecta.services.impl.AuthServiceImpl;

@RestController
@RequestMapping(path="api/v1")
public class AuthController {

    AuthServiceImpl AuthServiceImpl;
    
    @PostMapping(path="/registration")
    public ResponseEntity<UserDto> register(@RequestBody UserDto req)
    {
        UserDto userDto = AuthServiceImpl.registration(req);
        return ResponseEntity.ok(userDto);
    }

}
