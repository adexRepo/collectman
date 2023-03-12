package projects.dex.collecta.models;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter @AllArgsConstructor @EqualsAndHashCode
public class AuthRegistrationRequest  {
    
    @NotBlank
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;

}

