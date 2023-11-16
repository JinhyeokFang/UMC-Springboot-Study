package uk.jinhy.umcstudy.service.restaurant;

import uk.jinhy.umcstudy.domain.Restaurant;
import uk.jinhy.umcstudy.dto.restaurant.RestaurantRequestDTO;

public interface RestaurantCommandService {
    Restaurant addRestaurant(RestaurantRequestDTO.AddRestaurantDTO request);
}
