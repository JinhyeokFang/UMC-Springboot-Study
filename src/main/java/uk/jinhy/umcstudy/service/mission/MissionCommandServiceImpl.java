package uk.jinhy.umcstudy.service.mission;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.jinhy.umcstudy.domain.Restaurant;
import uk.jinhy.umcstudy.domain.UserMission;
import uk.jinhy.umcstudy.dto.mission.MissionRequestDTO;
import uk.jinhy.umcstudy.repository.mission.MissionRepository;
import uk.jinhy.umcstudy.repository.restaurant.RestaurantRepository;

@RequiredArgsConstructor
@Service
public class MissionCommandServiceImpl implements MissionCommandService {
    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    @Override
    public UserMission addMission(MissionRequestDTO.AddMissionDTO dto) {
        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId()).get();
        UserMission mission = UserMission.builder()
                .goal(dto.getGoal())
                .point(dto.getPoint())
                .restaurant(restaurant)
                .status("CREATED")
                .user(null)
                .build();
        missionRepository.save(mission);
        return mission;
    }
}
