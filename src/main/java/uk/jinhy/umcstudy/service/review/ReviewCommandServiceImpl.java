package uk.jinhy.umcstudy.service.review;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.jinhy.umcstudy.domain.Restaurant;
import uk.jinhy.umcstudy.domain.Review;
import uk.jinhy.umcstudy.dto.review.ReviewRequestDTO;
import uk.jinhy.umcstudy.repository.restaurant.RestaurantRepository;
import uk.jinhy.umcstudy.repository.review.ReviewRepository;

@RequiredArgsConstructor
@Service
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    @Override
    public Review addReview(ReviewRequestDTO.AddReviewDTO dto) {
        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId()).get();
        Review review = Review.builder()
                .restaurant(restaurant)
                .rate(dto.getRate())
                .description(dto.getDescription())
                .build();
        reviewRepository.save(review);
        return review;
    }
}
