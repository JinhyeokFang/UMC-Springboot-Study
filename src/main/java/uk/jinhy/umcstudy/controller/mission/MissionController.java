package uk.jinhy.umcstudy.controller.mission;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uk.jinhy.umcstudy.apiPayload.ApiResponse;
import uk.jinhy.umcstudy.converter.mission.MissionConverter;
import uk.jinhy.umcstudy.domain.UserMission;
import uk.jinhy.umcstudy.dto.mission.MissionRequestDTO;
import uk.jinhy.umcstudy.dto.mission.MissionResponseDTO;
import uk.jinhy.umcstudy.service.mission.MissionCommandService;
import uk.jinhy.umcstudy.service.mission.MissionQueryService;
import uk.jinhy.umcstudy.validation.annotation.ExistRestaurant;
import uk.jinhy.umcstudy.validation.annotation.MissionStatusCreated;
import uk.jinhy.umcstudy.validation.annotation.PageNumber;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("mission")
public class MissionController {
    private final MissionQueryService missionQueryService;
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

    @GetMapping("/restaurant/{id}")
    @Operation(summary = "유저 리뷰 불러오기 API",description = "특정 레스토랑의 리뷰를 API이며, 페이징을 포함합니다. path variable로 restaurant의 id를, query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "RESTAURANT4001", description = "잘못된 Restaurant Id",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "PAGE4001", description = "잘못된 Page Number",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "page", description = "불러올 리뷰의 페이지 번호"),
            @Parameter(name = "id", description = "불러올 리뷰의 레스토랑 아이디")
    })
    public ApiResponse<MissionResponseDTO.GetRestaurantMissionDTO> getRestaurantMission(
            @ExistRestaurant @PathVariable("id") Long id,
            @PageNumber @RequestParam(value = "page") Long page
    ) {
        Page<UserMission> missionPage = missionQueryService.getRestaurantReview(id, page - 1, 10L);
        return ApiResponse.onSuccess(missionConverter.toGetRestaurantMissionDto(missionPage));
    }
}
