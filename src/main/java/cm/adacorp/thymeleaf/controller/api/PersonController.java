package cm.adacorp.thymeleaf.controller.api;

import cm.adacorp.thymeleaf.services.interf.PersonServiceInterf;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PersonController {
    private final PersonServiceInterf personServiceInterf;

}
