package uk.jinhy.umcstudy.service.temp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.jinhy.umcstudy.apiPayload.code.status.ErrorStatus;
import uk.jinhy.umcstudy.apiPayload.exception.handler.TempHandler;

@Service
@RequiredArgsConstructor
public class TempCommandQueryService implements TempService {
    @Override
    public void CheckFlag(int flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
