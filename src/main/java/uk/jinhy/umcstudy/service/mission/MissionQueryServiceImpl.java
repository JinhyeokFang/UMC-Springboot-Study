package uk.jinhy.umcstudy.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uk.jinhy.umcstudy.domain.Restaurant;
import uk.jinhy.umcstudy.domain.UserMission;
import uk.jinhy.umcstudy.repository.mission.MissionRepository;
import uk.jinhy.umcstudy.repository.restaurant.RestaurantRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public boolean isExist(Long id) {
        Optional<UserMission> mission = missionRepository.findById(id);
        return mission.isPresent();
    }

    @Override
    public boolean isStatusCreated(Long id) {
        UserMission mission = missionRepository.findById(id).get();
        return mission.getStatus().equals("CREATED");
    }

    @Override
    public Page<UserMission> getRestaurantReview(Long restaurantId, Long page, Long size) {
        PageRequest pageRequest = PageRequest.of(page.intValue(), 10);
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        return missionRepository.findByRestaurant(restaurant, pageRequest);
    }
}
