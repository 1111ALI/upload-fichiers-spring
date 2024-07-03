package cm.adacorp.thymeleaf.services.impl;

import cm.adacorp.thymeleaf.entity.Restaurant;
import cm.adacorp.thymeleaf.repository.RestaurantRepository;
import cm.adacorp.thymeleaf.services.interf.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Override
    public Restaurant create(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }
}
