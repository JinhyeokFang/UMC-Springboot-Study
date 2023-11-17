package uk.jinhy.umcstudy.dto.review;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import uk.jinhy.umcstudy.validation.annotation.ExistRestaurant;

public class ReviewRequestDTO {
    @Getter
    public static class AddReviewDTO {
        @ExistRestaurant
        Long restaurantId;
        @NotBlank
        String description;
        @NotNull
        float rate;
    }
}

