package uk.jinhy.umcstudy.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodType {
    @Id
    private Long id;

    @Column(length = 10, nullable = false)
    private String name;

    @OneToMany(mappedBy = "foodType", cascade = CascadeType.ALL)
    private List<FavoriteFoodType> favoriteFoodTypeList = new ArrayList<>();
}
