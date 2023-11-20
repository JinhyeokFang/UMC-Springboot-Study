package uk.jinhy.umcstudy.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uk.jinhy.umcstudy.apiPayload.code.status.ErrorStatus;
import uk.jinhy.umcstudy.validation.annotation.PageNumber;

@Component
@RequiredArgsConstructor
public class PageNumberValidator implements ConstraintValidator<PageNumber, Long> {
    @Override
    public void initialize(PageNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = 0 < value;
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.BAD_PAGE_NUMBER_EXCEPTION.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
