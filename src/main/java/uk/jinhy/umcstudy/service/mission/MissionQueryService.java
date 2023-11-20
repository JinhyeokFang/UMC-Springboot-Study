package uk.jinhy.umcstudy.service.mission;

import org.springframework.data.domain.Page;
import uk.jinhy.umcstudy.domain.UserMission;

public interface MissionQueryService {
    boolean isExist(Long value);
    boolean isStatusCreated(Long value);
    Page<UserMission> getRestaurantMission(Long restaurantId, Long page, Long size);
    Page<UserMission> getMyInProgressMission(String userId, Long page, Long size);
}
