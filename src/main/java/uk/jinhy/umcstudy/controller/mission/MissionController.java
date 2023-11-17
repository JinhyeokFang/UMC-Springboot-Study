package uk.jinhy.umcstudy.controller.mission;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.jinhy.umcstudy.apiPayload.ApiResponse;
import uk.jinhy.umcstudy.converter.mission.MissionConverter;
import uk.jinhy.umcstudy.domain.Restaurant;
import uk.jinhy.umcstudy.domain.UserMission;
import uk.jinhy.umcstudy.dto.mission.MissionRequestDTO;
import uk.jinhy.umcstudy.dto.mission.MissionResponseDTO;
import uk.jinhy.umcstudy.service.mission.MissionCommandService;

@RequiredArgsConstructor
@RestController
@RequestMapping("mission")
public class MissionController {
    private final MissionCommandService missionCommandService;
    private final MissionConverter missionConverter;

    @PostMapping
    public ApiResponse<MissionResponseDTO.AddMissionDTO> register(@RequestBody @Valid MissionRequestDTO.AddMissionDTO dto) {
        UserMission mission = missionCommandService.addMission(dto);
        return ApiResponse.onSuccess(missionConverter.toDto(mission));
    }
}
