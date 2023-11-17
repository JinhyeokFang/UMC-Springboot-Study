package uk.jinhy.umcstudy.controller.restaurant;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.jinhy.umcstudy.apiPayload.ApiResponse;
import uk.jinhy.umcstudy.converter.restaurant.RestaurantConverter;
import uk.jinhy.umcstudy.domain.Restaurant;
import uk.jinhy.umcstudy.dto.restaurant.RestaurantRequestDTO;
import uk.jinhy.umcstudy.dto.restaurant.RestaurantResponseDTO;
import uk.jinhy.umcstudy.service.restaurant.RestaurantCommandService;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("restaurant")
public class RestaurantController {
    private final RestaurantCommandService restaurantCommandService;
    private final RestaurantConverter restaurantConverter;

    @PostMapping
    public ApiResponse<RestaurantResponseDTO.AddRestaurantDTO> register(@RequestBody @Valid RestaurantRequestDTO.AddRestaurantDTO dto) {
        Restaurant restaurant = restaurantCommandService.addRestaurant(dto);
        return ApiResponse.onSuccess(restaurantConverter.toDto(restaurant));
    }
}
