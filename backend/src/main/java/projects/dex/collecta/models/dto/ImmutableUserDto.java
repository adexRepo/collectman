package projects.dex.collecta.models.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter @EqualsAndHashCode
public class ImmutableUserDto {
    private final String     firstName   ;
    private final String     lastName    ;
    private final String     full_name   ;
    private final String     username    ;
    private final Long       telNo       ;
    private final String     email       ;
    private final String     ipAddr      ;
    private final String     password    ;


    public ImmutableUserDto(UserDto userDto) {
        this.firstName = userDto.getFirstName();
        this.lastName  = userDto.getLastName ();
        this.full_name = userDto.getFull_name();
        this.username  = userDto.getUsername ();
        this.telNo     = userDto.getTelNo    ();
        this.email     = userDto.getEmail    ();
        this.ipAddr    = userDto.getIpAddr   ();
        this.password  = userDto.getPassword ();
    }


}
