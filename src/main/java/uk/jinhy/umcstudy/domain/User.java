package uk.jinhy.umcstudy.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {
    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "social_media_type", columnDefinition = "VARCHAR(30)", nullable = false)
    private SocialMediaType socialMediaType;

    @Column(name = "social_media_id", length = 100, nullable = false)
    private String socialMediaId;

    @Column(length = 40, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)", nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private LocalDate birthday;

    @Column(length = 100, nullable = false)
    private String address;

    @Column(name = "detail_address", length = 100, nullable = false)
    private String detailAddress;

    @ColumnDefault("0")
    @Column(nullable = false)
    private int point;

    @Column(name = "location_consent", nullable = false)
    private boolean locationConsent;

    @Column(name = "marketing_consent", nullable = false)
    private boolean marketingConsent;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<FavoriteFoodType> favoriteFoodTypeList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMission> userMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ReviewRequestNotification> reviewRequestNotificationList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<NewMissionNotification> newMissionNotificationList = new ArrayList<>();
}