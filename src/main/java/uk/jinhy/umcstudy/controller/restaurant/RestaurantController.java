package uk.jinhy.umcstudy.controller.restaurant;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.jinhy.umcstudy.apiPayload.ApiResponse;
import uk.jinhy.umcstudy.domain.Restaurant;
import uk.jinhy.umcstudy.dto.restaurant.RestaurantRequestDTO;
import uk.jinhy.umcstudy.service.restaurant.RestaurantCommandService;

@RequiredArgsConstructor
@RestController
@RequestMapping("restaurant")
public class RestaurantController {
    private final RestaurantCommandService restaurantCommandService;

    @PostMapping
    public ApiResponse<Object> register(@RequestBody @Valid RestaurantRequestDTO.AddRestaurantDTO dto) {
        Restaurant restaurant = restaurantCommandService.addRestaurant(dto);
        return ApiResponse.onSuccess(null);
    }
}
