package uk.jinhy.umcstudy.repository.mission;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.jinhy.umcstudy.domain.UserMission;

public interface MissionRepository extends JpaRepository<UserMission, Long> {
}
