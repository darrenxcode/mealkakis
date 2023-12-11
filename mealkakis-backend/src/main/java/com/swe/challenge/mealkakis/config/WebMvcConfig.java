//package com.swe.challenge.mealkakis.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.task.AsyncTaskExecutor;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebMvcConfig implements WebMvcConfigurer {
//
//    @Override
//    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//        configurer.setDefaultTimeout(0); // Set timeout to 0 to disable it
//        configurer.setTaskExecutor(getTaskExecutor());
//    }
//
//    private AsyncTaskExecutor getTaskExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(10);
//        executor.setMaxPoolSize(20);
//        executor.setKeepAliveSeconds(60);
//        executor.setThreadNamePrefix("sse-executor-");
//        executor.initialize();
//        return executor;
//    }
//}
