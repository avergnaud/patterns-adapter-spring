package com.poc.com.poc.listenableFuture;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class SpringConfiguration {
    @Bean
    public SomeBean helloWorld(){
        return new SomeBean();
    }
}
