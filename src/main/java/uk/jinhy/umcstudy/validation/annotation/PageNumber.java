package uk.jinhy.umcstudy.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import uk.jinhy.umcstudy.validation.validator.PageNumberValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageNumberValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface PageNumber {
    String message() default "잘못된 페이지 번호입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
