package com.gyrocentral;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class EventSource {
    private static final Logger log = LoggerFactory.getLogger(EventSource.class);

//    @Scheduled(cron = "*/2 * * * * *")
//    public void checkScheduling(){
//        log.info("functional");
//
//    }

    @GetMapping(path="/EventSource")
    public SseEmitter streamSseMvc() {
        SseEmitter sseEmitter = new SseEmitter(Long.valueOf("5000"));
        ExecutorService sseMvcExecutor = Executors.newSingleThreadExecutor();
        sseMvcExecutor.execute(() -> {
                try{
                        SseEmitter.SseEventBuilder event = SseEmitter.event().data("~5sec have passed");
                        sseEmitter.send(event);
                        Thread.sleep(1000);
                } catch(Exception ex) {
                    sseEmitter.completeWithError(ex);
                }


        });
        return sseEmitter;
    }

}
