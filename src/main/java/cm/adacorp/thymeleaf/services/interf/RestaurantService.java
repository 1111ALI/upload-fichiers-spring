package cm.adacorp.thymeleaf.services.interf;

import cm.adacorp.thymeleaf.entity.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant create(Restaurant restaurant);

    List<Restaurant> getAll();
}
