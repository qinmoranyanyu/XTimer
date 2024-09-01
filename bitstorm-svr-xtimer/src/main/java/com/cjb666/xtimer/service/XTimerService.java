package com.cjb666.xtimer.service;

import com.cjb666.api.dto.xtimer.TimerDTO;

import java.util.List;

public interface XTimerService {

    Long CreateTimer(TimerDTO timerDTO);

    void DeleteTimer(String app, long id);

    void Update(TimerDTO timerDTO);

    TimerDTO GetTimer(String app, long id);

    void EnableTimer(String app, long id);

    void UnEnableTimer(String app, long id);

    List<TimerDTO> GetAppTimers(String app);
}
