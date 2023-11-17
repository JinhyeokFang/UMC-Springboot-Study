package uk.jinhy.umcstudy.dto.review;

import lombok.Builder;
import lombok.Getter;

public class ReviewResponseDTO {
    @Getter
    @Builder
    public static class AddReviewDTO {
        Long restaurantId;
        String description;
        float rate;
    }
}
