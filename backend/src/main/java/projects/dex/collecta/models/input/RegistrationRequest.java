package projects.dex.collecta.models.input;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter @AllArgsConstructor @EqualsAndHashCode
public class RegistrationRequest {
    
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;

}

