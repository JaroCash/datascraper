package com.jarek.datascraper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class ApicreatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApicreatorApplication.class, args);
	}

	@Bean
	public Executor taskExecutor() {

		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(12);
		executor.setMaxPoolSize(15);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("ScrapingThread- ");
		executor.initialize();
		return executor;
	}

}

