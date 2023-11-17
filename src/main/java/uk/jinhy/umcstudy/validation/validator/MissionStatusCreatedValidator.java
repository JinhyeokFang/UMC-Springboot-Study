package uk.jinhy.umcstudy.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uk.jinhy.umcstudy.apiPayload.code.status.ErrorStatus;
import uk.jinhy.umcstudy.service.mission.MissionQueryService;
import uk.jinhy.umcstudy.validation.annotation.MissionStatusCreated;

@Component
@RequiredArgsConstructor
public class MissionStatusCreatedValidator implements ConstraintValidator<MissionStatusCreated, Long> {
    private final MissionQueryService missionQueryService;

    @Override
    public void initialize(MissionStatusCreated constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isExist = missionQueryService.isExist(value);
        if (!isExist) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.BAD_MISSION_EXCEPTION.toString()).addConstraintViolation();
            return false;
        }

        boolean isValid = missionQueryService.isStatusCreated(value);
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.BAD_MISSION_STATUS_EXCEPTION.toString()).addConstraintViolation();
        }

        return false;
    }
}