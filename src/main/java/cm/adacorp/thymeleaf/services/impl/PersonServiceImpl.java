package cm.adacorp.thymeleaf.services.impl;

import cm.adacorp.thymeleaf.repository.PersonRepository;
import cm.adacorp.thymeleaf.services.interf.PersonServiceInterf;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonServiceInterf {
    private final PersonRepository personRepository;
}
