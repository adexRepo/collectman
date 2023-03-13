package projects.dex.collecta.services;

import projects.dex.collecta.models.dto.UserDto;

public interface AuthService {
    
    UserDto registration(UserDto auth);
}