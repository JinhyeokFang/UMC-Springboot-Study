package uk.jinhy.umcstudy.dto.mission;

import lombok.Builder;
import lombok.Getter;

public class MissionResponseDTO {
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
}
