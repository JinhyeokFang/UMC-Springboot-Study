package uk.jinhy.umcstudy.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uk.jinhy.umcstudy.controller.user.UserRepository;
import uk.jinhy.umcstudy.domain.Review;
import uk.jinhy.umcstudy.domain.User;
import uk.jinhy.umcstudy.repository.review.ReviewRepository;

@RequiredArgsConstructor
@Service
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    @Override
    public Page<Review> getMyReviews(User user, Long page, Long size) {
        User userForTest = userRepository.findById("Test").get();
        PageRequest pageRequest = PageRequest.of(page.intValue(), size.intValue());
        return reviewRepository.findByUser(userForTest, pageRequest);
    }
}
