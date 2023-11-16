package uk.jinhy.umcstudy.apiPayload.exception.handler;

import uk.jinhy.umcstudy.apiPayload.code.BaseErrorCode;
import uk.jinhy.umcstudy.apiPayload.exception.GeneralException;

public class RestaurantHandler extends GeneralException {
    public RestaurantHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
