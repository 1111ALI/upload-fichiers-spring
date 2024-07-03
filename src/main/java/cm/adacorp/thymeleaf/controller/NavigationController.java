package cm.adacorp.thymeleaf.controller;

import cm.adacorp.thymeleaf.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class NavigationController {

    // Injection de la dependance du controlleur de restaurants
    private final RestaurantController restaurantController;
    private final UploadedFileController uploadedFileController;

    @GetMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("message-test", "Hi test offline Thymeleaf");
        return "index";
    }

    @GetMapping(value = "/home")
    public String home(Model model) {
        model.addAttribute("restaurants", restaurantController.getAll());
        return "home";
    }

    @GetMapping(value = "/all")
    public String getAllRestaurants(Model model) {
        model.addAttribute("restaurants", restaurantController.getAll());
        return "restaurants/all";
    }

    @GetMapping(value = "/create-new")
    public String nouveauRestaurant(@ModelAttribute Restaurant restaurant, Model model) {
        return "restaurants/create";
    }

    @PostMapping("/new")
    public String createRestaurant(@ModelAttribute Restaurant restaurant, Model model) {
        restaurantController.create(restaurant);
        return "redirect:/all";
    }

    @GetMapping("/form")
    public String form(Model model){
        return "upload";
    }

    @PostMapping("/upload")
    public  String uploadFile(@RequestParam("file") MultipartFile file, Model model){
        Map<String, String> reponse = new HashMap<>();
        reponse = uploadedFileController.saveFile(file);
        model.addAttribute("message","File uploaded successfully");
        model.addAttribute("reponse", reponse);
        return "upload";
    }


}
