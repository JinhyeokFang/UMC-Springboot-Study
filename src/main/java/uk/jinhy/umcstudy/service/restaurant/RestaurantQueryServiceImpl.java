package uk.jinhy.umcstudy.service.restaurant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.jinhy.umcstudy.domain.Restaurant;
import uk.jinhy.umcstudy.repository.restaurant.RestaurantRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RestaurantQueryServiceImpl implements RestaurantQueryService {
    private final RestaurantRepository restaurantRepository;
    @Override
    public boolean isExist(Long id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        return restaurant.isPresent();
    }
}
