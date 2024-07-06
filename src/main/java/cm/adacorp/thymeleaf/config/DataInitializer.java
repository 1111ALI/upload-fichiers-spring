package cm.adacorp.thymeleaf.config;

import cm.adacorp.thymeleaf.entity.Person;
import cm.adacorp.thymeleaf.enums.PersonRole;
import cm.adacorp.thymeleaf.repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init(){
        Person person = new Person();
        person.setUsername("admin");
        person.setPassword(passwordEncoder.encode("mot2pass"));
        person.setRoles(Set.of(PersonRole.ADMIN,PersonRole.USER));
        personRepository.save(person);
    }

}
