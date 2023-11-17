package uk.jinhy.umcstudy.service.mission;

import uk.jinhy.umcstudy.domain.UserMission;
import uk.jinhy.umcstudy.dto.mission.MissionRequestDTO;

public interface MissionCommandService {
    UserMission addMission(MissionRequestDTO.AddMissionDTO dto);
    UserMission proceedMission(Long id);
}
