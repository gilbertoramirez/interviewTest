package com.solutions.coherent.interviewTest.configuration;

import com.solutions.coherent.interviewTest.configuration.DBMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ReservationConfiguration {
    @Bean
    @Scope("singleton")
    public DBMemory dbMemory(){
        return new DBMemory();
    }

    @Bean
    public ShutdownHook shutdownHook() {
        return new ShutdownHook();
    }
}
