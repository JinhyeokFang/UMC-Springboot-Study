package uk.jinhy.umcstudy.service.review;

import uk.jinhy.umcstudy.domain.Review;
import uk.jinhy.umcstudy.dto.review.ReviewRequestDTO;

public interface ReviewCommandService {
    Review addReview(ReviewRequestDTO.AddReviewDTO dto);
}
