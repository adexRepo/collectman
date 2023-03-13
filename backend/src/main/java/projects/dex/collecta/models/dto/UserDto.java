package projects.dex.collecta.models.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter @AllArgsConstructor @EqualsAndHashCode
public class UserDto  {
    
    private String     firstName   ;
    private String     lastName    ;
    private String     full_name   ;
    private String     username    ;
    private Long       telNo       ;
    private String     email       ;
    private String     ipAddr      ;
    private String     password    ;


    public ImmutableUserDto toImmutable() {
        return new ImmutableUserDto(this);
    }
}

