package uk.jinhy.umcstudy.dto.review;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class ReviewResponseDTO {
    @Getter
    @Builder
    public static class ReviewDTO {
        Long restaurantId;
        String description;
        float rate;
    }

    @Getter
    @Builder
    public static class AddReviewDTO {
        Long restaurantId;
        String description;
        float rate;
    }

    @Getter
    @Builder
    public static class GetMyReviewDTO {
        List<ReviewDTO> reviews;
        Long numberOfPages;
    }
}
