package cm.adacorp.thymeleaf.entity;

import cm.adacorp.thymeleaf.enums.PersonRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "persons")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;
    private String username;
    private String email;
    private UUID activationCode;
    private UUID resetCode;
    private String password;
    private String passwordConfirmation;
    private Set<PersonRole> roles;
    private boolean isActivated;

}
