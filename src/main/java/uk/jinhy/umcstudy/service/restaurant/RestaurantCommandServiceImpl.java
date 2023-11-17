package uk.jinhy.umcstudy.service.restaurant;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.jinhy.umcstudy.apiPayload.code.status.ErrorStatus;
import uk.jinhy.umcstudy.apiPayload.exception.handler.RestaurantHandler;
import uk.jinhy.umcstudy.domain.FoodType;
import uk.jinhy.umcstudy.domain.Restaurant;
import uk.jinhy.umcstudy.dto.restaurant.RestaurantRequestDTO;
import uk.jinhy.umcstudy.repository.foodtype.FoodTypeRepository;
import uk.jinhy.umcstudy.repository.restaurant.RestaurantRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RestaurantCommandServiceImpl implements RestaurantCommandService {
    private final RestaurantRepository restaurantRepository;
    private final FoodTypeRepository foodTypeRepository;

    @Transactional
    @Override
    public Restaurant addRestaurant(RestaurantRequestDTO.AddRestaurantDTO request) {
        Optional<FoodType> foodType = foodTypeRepository.findById(request.getFoodTypeId());
        if (foodType.isEmpty()) {
            throw new RestaurantHandler(ErrorStatus.BAD_FOODTYPE_EXCEPTION);
        }
        Restaurant restaurant = Restaurant.builder()
                .name(request.getName())
                .longitude(request.getLongitude())
                .latitude(request.getLatitude())
                .owner(null)
                .foodType(foodType.get())
                .status("생성됨")
                .build();
        restaurantRepository.save(restaurant);
        return restaurant;
    }
}
