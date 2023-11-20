package uk.jinhy.umcstudy.service.review;

import org.springframework.data.domain.Page;
import uk.jinhy.umcstudy.domain.Review;
import uk.jinhy.umcstudy.domain.User;

public interface ReviewQueryService {
    Page<Review> getMyReviews(User user, Long page, Long size);
}
