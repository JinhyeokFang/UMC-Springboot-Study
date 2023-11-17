package uk.jinhy.umcstudy.converter.mission;

import org.springframework.stereotype.Component;
import uk.jinhy.umcstudy.domain.UserMission;
import uk.jinhy.umcstudy.dto.mission.MissionResponseDTO;

@Component
public class MissionConverter {
    public MissionResponseDTO.AddMissionDTO toAddMissionDto(UserMission mission) {
        return MissionResponseDTO.AddMissionDTO.builder()
                .point(mission.getPoint())
                .goal(mission.getGoal())
                .restaurantId(mission.getRestaurant().getId())
                .build();
    }

    public MissionResponseDTO.ProceedMissionDTO toProceedMissionDto(UserMission mission) {
        return MissionResponseDTO.ProceedMissionDTO.builder()
                .point(mission.getPoint())
                .goal(mission.getGoal())
                .restaurantId(mission.getRestaurant().getId())
                .build();
    }
}
