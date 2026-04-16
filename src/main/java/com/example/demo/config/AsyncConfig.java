package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync   // ← this enables @Async throughout the whole app
public class AsyncConfig {
}
