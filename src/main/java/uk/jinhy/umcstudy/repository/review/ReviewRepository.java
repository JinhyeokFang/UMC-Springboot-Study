package uk.jinhy.umcstudy.repository.review;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.jinhy.umcstudy.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
