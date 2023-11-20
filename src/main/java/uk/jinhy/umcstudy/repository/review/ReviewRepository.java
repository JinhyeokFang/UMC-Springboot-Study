package uk.jinhy.umcstudy.repository.review;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uk.jinhy.umcstudy.domain.Review;
import uk.jinhy.umcstudy.domain.User;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findByUser(User user, Pageable pageable);
}
