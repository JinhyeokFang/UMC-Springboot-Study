package uk.jinhy.umcstudy.dto.restaurant;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

public class RestaurantResponseDTO {
    @Getter
    @Builder
    public static class AddRestaurantDTO {
        String name;
        Long foodTypeId;
        float latitude;
        float longitude;
    }
}
