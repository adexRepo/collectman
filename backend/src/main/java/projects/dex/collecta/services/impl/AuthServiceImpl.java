package projects.dex.collecta.services.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;
import projects.dex.collecta.config.security.JwtService;
import projects.dex.collecta.models.AuthRequest;
import projects.dex.collecta.models.AuthResponse;
import projects.dex.collecta.models.RegistRequest;
import projects.dex.collecta.repository.UserBaseRepository;
import projects.dex.collecta.repository.entity.RoleUser;
import projects.dex.collecta.repository.entity.UserBase;
import projects.dex.collecta.services.AuthService;

@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserBaseRepository userBaseRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager auththenticationManager;
    // private ModelMapper modelMapper;

    @Override
    public AuthResponse registration(RegistRequest request) {
        var user = UserBase.builder()
                .fullName(request.getFullName())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .telNo(request.getTelNo())
                .username(request.getUsername())
                .isLocked(false)
                .passwords(passwordEncoder.encode(request.getPassword()))
                .role(RoleUser.AGENT)
                .build();

        userBaseRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder().token(jwtToken).build();
    }

    @Override
    public AuthResponse authenticate(AuthRequest auth) {

        // auththenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
        // ));

        return null;
    }

}
