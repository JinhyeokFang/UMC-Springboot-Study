package uk.jinhy.umcstudy.controller.review;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uk.jinhy.umcstudy.apiPayload.ApiResponse;
import uk.jinhy.umcstudy.converter.review.ReviewConverter;
import uk.jinhy.umcstudy.domain.Review;
import uk.jinhy.umcstudy.domain.User;
import uk.jinhy.umcstudy.dto.review.ReviewRequestDTO;
import uk.jinhy.umcstudy.dto.review.ReviewResponseDTO;
import uk.jinhy.umcstudy.service.review.ReviewCommandService;
import uk.jinhy.umcstudy.service.review.ReviewQueryService;
import uk.jinhy.umcstudy.validation.annotation.PageNumber;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("review")
public class ReviewController {
    private final ReviewQueryService reviewQueryService;
    private final ReviewCommandService reviewCommandService;
    private final ReviewConverter reviewConverter;

    @PostMapping
    public ApiResponse<ReviewResponseDTO.AddReviewDTO> register(@RequestBody @Valid ReviewRequestDTO.AddReviewDTO dto) {
        Review review = reviewCommandService.addReview(dto);
        return ApiResponse.onSuccess(reviewConverter.toDto(review));
    }

    @GetMapping("/user")
    @Operation(summary = "유저 리뷰 불러오기 API",description = "유저 리뷰를 불러오는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "PAGE4001", description = "잘못된 Page Number",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "page", description = "불러올 리뷰의 페이지 번호")
    })
    public ApiResponse<ReviewResponseDTO.GetMyReviewDTO> getMyReview(@PageNumber @RequestParam(value = "page") Long page) {
        Page<Review> reviewPage = reviewQueryService.getMyReviews(null, page - 1, 10L);
        return ApiResponse.onSuccess(reviewConverter.toGetMyReviewDto(reviewPage));
    }
}
