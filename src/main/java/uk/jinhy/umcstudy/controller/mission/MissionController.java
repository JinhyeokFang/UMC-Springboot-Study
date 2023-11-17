package uk.jinhy.umcstudy.controller.mission;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uk.jinhy.umcstudy.apiPayload.ApiResponse;
import uk.jinhy.umcstudy.converter.mission.MissionConverter;
import uk.jinhy.umcstudy.domain.UserMission;
import uk.jinhy.umcstudy.dto.mission.MissionRequestDTO;
import uk.jinhy.umcstudy.dto.mission.MissionResponseDTO;
import uk.jinhy.umcstudy.service.mission.MissionCommandService;
import uk.jinhy.umcstudy.validation.annotation.MissionStatusCreated;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("mission")
public class MissionController {
    private final MissionCommandService missionCommandService;
    private final MissionConverter missionConverter;

    @PostMapping
    public ApiResponse<MissionResponseDTO.AddMissionDTO> register(@RequestBody @Valid MissionRequestDTO.AddMissionDTO dto) {
        UserMission mission = missionCommandService.addMission(dto);
        return ApiResponse.onSuccess(missionConverter.toAddMissionDto(mission));
    }

    @PatchMapping("/{id}/proceed")
    public ApiResponse<MissionResponseDTO.ProceedMissionDTO> proceed(@MissionStatusCreated @PathVariable("id") Long id) {
        UserMission mission = missionCommandService.proceedMission(id);
        return ApiResponse.onSuccess(missionConverter.toProceedMissionDto(mission));
    }
}
