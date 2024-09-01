package com.cjb666.xtimer.feign;

import com.cjb666.api.dto.xtimer.TimerDTO;
import com.cjb666.api.feign.XTimerClient;
import com.cjb666.xtimer.service.XTimerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class XTimerFeignController implements XTimerClient {

    @Autowired
    XTimerService xTimerService;

    @Override
    public Long createTimer(TimerDTO timerDTO) {
        return xTimerService.CreateTimer(timerDTO);
    }

    @Override
    public void enableTimer(String app, Long timerId, MultiValueMap<String, String> headers) {
        xTimerService.EnableTimer(app, timerId);
    }
}
