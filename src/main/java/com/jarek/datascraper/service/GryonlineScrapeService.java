package com.jarek.datascraper.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class GryonlineScrapeService {

    @Async
    public void print(int time) throws Exception {
       long id = Thread.currentThread()
              .getId();
       Thread.sleep(2000+time);
        System.out.println("Thread running" + id);

    }


}
