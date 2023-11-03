package uk.jinhy.umcstudy.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class NewMissionNotification extends BaseEntity {
    @Id
    private Long id;

    @Column(length = 200, nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_mission_id")
    private UserMission userMission;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
