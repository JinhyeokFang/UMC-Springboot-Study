package uk.jinhy.umcstudy.converter.restaurant;

import org.springframework.stereotype.Component;
import uk.jinhy.umcstudy.domain.Restaurant;
import uk.jinhy.umcstudy.dto.restaurant.RestaurantResponseDTO;

@Component
public class RestaurantConverter {
    public RestaurantResponseDTO.AddRestaurantDTO toDto(Restaurant restaurant) {
        return RestaurantResponseDTO.AddRestaurantDTO.builder()
                .name(restaurant.getName())
                .foodTypeId(restaurant.getFoodType().getId())
                .latitude(restaurant.getLatitude())
                .longitude(restaurant.getLongitude())
                .build();
    }
}
