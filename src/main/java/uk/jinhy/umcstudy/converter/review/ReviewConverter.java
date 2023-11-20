package uk.jinhy.umcstudy.converter.review;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import uk.jinhy.umcstudy.domain.Review;
import uk.jinhy.umcstudy.dto.review.ReviewResponseDTO;

import java.util.List;

@Component
public class ReviewConverter {
    public ReviewResponseDTO.AddReviewDTO toDto(Review review) {
        return ReviewResponseDTO.AddReviewDTO.builder()
                .description(review.getDescription())
                .restaurantId(review.getRestaurant().getId())
                .rate(review.getRate())
                .build();
    }

    public ReviewResponseDTO.GetMyReviewDTO toGetMyReviewDto(Page<Review> page) {
        Long totalPage = (long) page.getTotalPages();
        List<ReviewResponseDTO.ReviewDTO> reviews = page.getContent()
                .stream().map(review -> ReviewResponseDTO.ReviewDTO
                    .builder()
                    .restaurantId(review.getRestaurant().getId())
                    .rate(review.getRate())
                    .description(review.getDescription())
                    .build()
                ).toList();
        return ReviewResponseDTO.GetMyReviewDTO.builder()
                .reviews(reviews)
                .numberOfPages(totalPage)
                .build();
    }
}
