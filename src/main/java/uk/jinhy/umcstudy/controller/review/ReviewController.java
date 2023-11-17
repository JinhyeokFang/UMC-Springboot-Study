package uk.jinhy.umcstudy.controller.review;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.jinhy.umcstudy.apiPayload.ApiResponse;
import uk.jinhy.umcstudy.converter.review.ReviewConverter;
import uk.jinhy.umcstudy.domain.Review;
import uk.jinhy.umcstudy.dto.review.ReviewRequestDTO;
import uk.jinhy.umcstudy.dto.review.ReviewResponseDTO;
import uk.jinhy.umcstudy.service.review.ReviewCommandService;

@RequiredArgsConstructor
@RestController
@RequestMapping("review")
public class ReviewController {
    private final ReviewCommandService reviewCommandService;
    private final ReviewConverter reviewConverter;

    @PostMapping
    public ApiResponse<ReviewResponseDTO.AddReviewDTO> register(@RequestBody @Valid ReviewRequestDTO.AddReviewDTO dto) {
        Review review = reviewCommandService.addReview(dto);
        return ApiResponse.onSuccess(reviewConverter.toDto(review));
    }
}
