package uk.jinhy.umcstudy.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import uk.jinhy.umcstudy.apiPayload.code.BaseErrorCode;
import uk.jinhy.umcstudy.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {
    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}
