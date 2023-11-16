package uk.jinhy.umcstudy.repository.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.jinhy.umcstudy.domain.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
