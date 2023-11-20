package uk.jinhy.umcstudy.dto.mission;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class MissionResponseDTO {
    @Getter
    @Builder
    public static class MissionDTO {
        String goal;
        int point;
        Long restaurantId;
    }

    @Getter
    @Builder
    public static class AddMissionDTO {
        String goal;
        int point;
        Long restaurantId;
    }

    @Getter
    @Builder
    public static class ProceedMissionDTO {
        String goal;
        int point;
        Long restaurantId;
    }

    @Getter
    @Builder
    public static class GetRestaurantMissionDTO {
        List<MissionDTO> missions;
        Long numberOfPages;
    }

    @Getter
    @Builder
    public static class GetMyInProgressMissionsDTO {
        List<MissionDTO> missions;
        Long numberOfPages;
    }

    @Getter
    @Builder
    public static class CompleteMissionDTO {
        String goal;
        int point;
        Long restaurantId;
    }
}
