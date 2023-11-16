package uk.jinhy.umcstudy.dto.restaurant;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class RestaurantRequestDTO {
    @Getter
    public static class AddRestaurantDTO {
        @NotBlank
        String name;
        @NotNull
        Long foodTypeId;
        @NotNull
        float latitude;
        @NotNull
        float longitude;
    }
}
