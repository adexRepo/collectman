package projects.dex.collecta.models.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import projects.dex.collecta.common.annotation.Ipv4;
import projects.dex.collecta.common.entity.BaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "user_base")
public class UserBase extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id         @GeneratedValue @Column(name   = "id"            )           private Long       id          ;
    @Column                            (name   = "first_name"    )           private String     firstName   ;
    @Column                            (name   = "last_name"     )           private String     lastName    ;
    @Column                            (name   = "full_name"     )           private String     full_name   ;
    @Column                            (name   = "username"      )           private String     username    ;
    @Column                            (name   = "telNo"         )           private Long       telNo       ;
    @Email(regexp = ".+[@].+[\\.].+") @Column(name = "email",unique = true)  private String     email       ;
    @Ipv4       @Column                (name   = "ip_addr"       )           private String     ipAddr      ;
    @Column                            (name   = "password"      )           private String     password    ;
    // @ManyToMany                        (fetch  = FetchType.EAGER )                         private Collection<RoleUser > roles = new ArrayList<RoleUser>();
}
