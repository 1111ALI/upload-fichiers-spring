package cm.adacorp.thymeleaf.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthConroller {
    @GetMapping("/login")
    public String login(){
        return "restaurants/login";
    }

    @PostMapping("/login")
    public String connect(){
        return "redirect:/home-auth";
    }

    @GetMapping("/home-auth")
    public String home(){
        return "restaurants/home";
    }
}
