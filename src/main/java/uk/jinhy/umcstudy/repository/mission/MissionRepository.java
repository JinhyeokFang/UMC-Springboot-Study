package uk.jinhy.umcstudy.repository.mission;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uk.jinhy.umcstudy.domain.Restaurant;
import uk.jinhy.umcstudy.domain.UserMission;

public interface MissionRepository extends JpaRepository<UserMission, Long> {
    Page<UserMission> findByRestaurant(Restaurant restaurant, Pageable pageable);
}
