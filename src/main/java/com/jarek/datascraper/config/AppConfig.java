package com.jarek.datascraper.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class AppConfig {

//
//    @Bean
//    public Executor taskExecutor() {
//
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(20);
//        executor.setMaxPoolSize(20);
//        executor.setQueueCapacity(500);
//        executor.setThreadNamePrefix("ScrapingThread- ");
//        executor.initialize();
//        return executor;
//    }
}