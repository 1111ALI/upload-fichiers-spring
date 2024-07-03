package cm.adacorp.thymeleaf.controller;

import cm.adacorp.thymeleaf.entity.Restaurant;
import cm.adacorp.thymeleaf.services.interf.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping("/new")
    public Restaurant create(@RequestBody Restaurant restaurant){
         return restaurantService.create(restaurant);
    }

    @GetMapping("/all")
    public List<Restaurant> getAll(){

        return  restaurantService.getAll();
    }
}
