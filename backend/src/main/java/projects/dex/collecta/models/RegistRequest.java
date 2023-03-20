package projects.dex.collecta.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistRequest {

    private String     firstName   ;
    private String     lastName    ;
    private String     fullName    ;
    private String     username    ;
    private Long       telNo       ;
    private String     email       ;
    private String     ipAddr      ;
    private String     password    ;
    
}
