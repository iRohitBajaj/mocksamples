package com.rohit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MockSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockSampleApplication.class, args);
    }
}
