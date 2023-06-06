package com.luv2code.springcoredemo.config;

import com.luv2code.springcoredemo.common.Coach;
import com.luv2code.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    // SwimCoach did not have @Component
    // Instead, we configured as a Spring bean using @Bean
    @Bean("aquatic") // custom bean id
    public Coach swimCoach() { // the bean id defaults to the method name
        return new SwimCoach();
    }
}
