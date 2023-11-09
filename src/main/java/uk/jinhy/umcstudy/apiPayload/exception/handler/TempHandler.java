package uk.jinhy.umcstudy.apiPayload.exception.handler;

import uk.jinhy.umcstudy.apiPayload.code.BaseErrorCode;
import uk.jinhy.umcstudy.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
