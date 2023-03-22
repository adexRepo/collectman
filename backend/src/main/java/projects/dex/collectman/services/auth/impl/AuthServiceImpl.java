package projects.dex.collectman.services.auth.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import projects.dex.collectman.config.jwt.JwtService;
import projects.dex.collectman.models.AuthRequest;
import projects.dex.collectman.models.AuthResponse;
import projects.dex.collectman.models.RegistRequest;
import projects.dex.collectman.repository.TokenRepository;
import projects.dex.collectman.repository.UserBaseRepository;
import projects.dex.collectman.repository.entity.Token;
import projects.dex.collectman.repository.entity.UserBase;
import projects.dex.collectman.repository.enums.RoleUser;
import projects.dex.collectman.repository.enums.TokenType;
import projects.dex.collectman.services.auth.AuthService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  private final UserBaseRepository userBaseRepository;

  private final PasswordEncoder passwordEncoder;

  private final JwtService jwtService;

  private final AuthenticationManager auththenticationManager;

  private final TokenRepository tokenRepository;

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
        .password(passwordEncoder.encode(request.getPassword()))
        .role(RoleUser.AGENT) // default aja
        .build();

    var UserSaved = userBaseRepository.save(user);
    var jwtToken = jwtService.generateToken(user);
    saveUserToken(UserSaved, jwtToken);

    return AuthResponse.builder().token(jwtToken).build();
  }

  @Override
  public AuthResponse authenticate(AuthRequest request) {

    auththenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
        request.getUsername(), request.getPassword()));

    var user = userBaseRepository.findByUsername(request.getUsername()).orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    revokeAllUserTokens(user);
    saveUserToken(user, jwtToken);
    return AuthResponse.builder().token(jwtToken).build();
  }

  private void saveUserToken(UserBase user, String jwtToken) {
    var token = Token.builder()
        .user(user)
        .token(jwtToken)
        .tokenType(TokenType.BEARER)
        .expired(false)
        .revoked(false)
        .build();
    tokenRepository.save(token);
  }

  private void revokeAllUserTokens(UserBase user) {
    var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
    if (validUserTokens.isEmpty())
      return;
    validUserTokens.forEach(token -> {
      token.setExpired(true);
      token.setRevoked(true);
    });
    tokenRepository.saveAll(validUserTokens);
  }

}
