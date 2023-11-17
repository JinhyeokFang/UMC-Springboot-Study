package uk.jinhy.umcstudy.converter.review;

import org.springframework.stereotype.Component;
import uk.jinhy.umcstudy.domain.Review;
import uk.jinhy.umcstudy.dto.review.ReviewResponseDTO;

@Component
public class ReviewConverter {
    public ReviewResponseDTO.AddReviewDTO toDto(Review review) {
        return ReviewResponseDTO.AddReviewDTO.builder()
                .description(review.getDescription())
                .restaurantId(review.getRestaurant().getId())
                .rate(review.getRate())
                .build();
    }
}
