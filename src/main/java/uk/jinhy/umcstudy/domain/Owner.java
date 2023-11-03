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
public class Owner {
    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "social_media_type", columnDefinition = "VARCHAR(30)", nullable = false)
    private SocialMediaType socialMediaType;

    @Column(name = "social_media_id", length = 100, nullable = false)
    private String socialMediaId;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Restaurant> restaurantList = new ArrayList<>();
}
