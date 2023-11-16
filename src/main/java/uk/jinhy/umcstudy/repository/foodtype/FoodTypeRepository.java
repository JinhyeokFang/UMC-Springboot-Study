package uk.jinhy.umcstudy.repository.foodtype;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.jinhy.umcstudy.domain.FoodType;

public interface FoodTypeRepository extends JpaRepository<FoodType, Long> {
}
