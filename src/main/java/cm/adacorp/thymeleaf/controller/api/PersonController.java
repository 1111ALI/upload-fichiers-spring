package cm.adacorp.thymeleaf.controller.api;

import cm.adacorp.thymeleaf.entity.Person;
import cm.adacorp.thymeleaf.repository.PersonRepository;
import cm.adacorp.thymeleaf.services.interf.PersonServiceInterf;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/")
public class PersonController {
    private final PersonServiceInterf personServiceInterf;
    private final PersonRepository personRepository;

    private final PasswordEncoder passwordEncoder;

    @PostMapping
    public void registerPerson(Person person){
        if(!person.getPassword().equals(person.getPasswordConfirmation())){
            throw new RuntimeException("Les deux mot de passe ne sont pas identiques");
        }
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setActivated(false);
        person.setActivationCode(UUID.randomUUID());
        personRepository.save(person);

    }

}
