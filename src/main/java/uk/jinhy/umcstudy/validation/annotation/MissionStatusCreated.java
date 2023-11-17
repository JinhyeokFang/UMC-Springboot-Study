package uk.jinhy.umcstudy.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import uk.jinhy.umcstudy.validation.validator.MissionStatusCreatedValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionStatusCreatedValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface MissionStatusCreated {
    String message() default "잘못된 미션 상태입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

