package uk.jinhy.umcstudy.converter.mission;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import uk.jinhy.umcstudy.domain.UserMission;
import uk.jinhy.umcstudy.dto.mission.MissionResponseDTO;

import java.util.List;

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

    public MissionResponseDTO.GetRestaurantMissionDTO toGetRestaurantMissionDto(Page<UserMission> missionPage) {
        Long numberOfPages = (long) missionPage.getTotalPages();
        List<MissionResponseDTO.MissionDTO> missions = missionPage.getContent()
                .stream().map(mission -> MissionResponseDTO.MissionDTO
                        .builder()
                        .restaurantId(mission.getRestaurant().getId())
                        .goal(mission.getGoal())
                        .point(mission.getPoint())
                        .build()
                ).toList();
        return MissionResponseDTO.GetRestaurantMissionDTO.builder()
                .missions(missions)
                .numberOfPages(numberOfPages)
                .build();
    }

    public MissionResponseDTO.GetMyInProgressMissionsDTO toGetMyInProgressMissionsDto(Page<UserMission> missionPage) {
        Long numberOfPages = (long) missionPage.getTotalPages();
        List<MissionResponseDTO.MissionDTO> missions = missionPage.getContent()
                .stream().map(mission -> MissionResponseDTO.MissionDTO
                        .builder()
                        .restaurantId(mission.getRestaurant().getId())
                        .goal(mission.getGoal())
                        .point(mission.getPoint())
                        .build()
                ).toList();
        return MissionResponseDTO.GetMyInProgressMissionsDTO.builder()
                .missions(missions)
                .numberOfPages(numberOfPages)
                .build();
    }

    public MissionResponseDTO.CompleteMissionDTO toCompleteMissionDto(UserMission mission) {
        return MissionResponseDTO.CompleteMissionDTO.builder()
                .point(mission.getPoint())
                .goal(mission.getGoal())
                .restaurantId(mission.getRestaurant().getId())
                .build();
    }
}
