package uk.jinhy.umcstudy.dto.mission;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import uk.jinhy.umcstudy.validation.annotation.ExistRestaurant;

public class MissionRequestDTO {
    @Getter
    public static class AddMissionDTO {
        @NotBlank
        String goal;
        @NotNull
        int point;
        @ExistRestaurant
        Long restaurantId;
    }
}
