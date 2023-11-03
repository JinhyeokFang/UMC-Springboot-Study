package uk.jinhy.umcstudy.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String goal;

    @Column(nullable = false)
    private int point;

    @OneToMany(mappedBy = "mission", fetch = FetchType.LAZY)
    private List<UserMission> userMissionList = new ArrayList<>();
}
