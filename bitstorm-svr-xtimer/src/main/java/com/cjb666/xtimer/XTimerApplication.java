package com.cjb666.xtimer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.cjb666"})
@EnableScheduling
@EnableAsync
public class XTimerApplication {

    public static void main(String[] args) {
        SpringApplication.run(XTimerApplication.class, args);
    }

}
