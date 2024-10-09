package com.benchmark.apimultithreading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ApiMultithreadingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiMultithreadingApplication.class, args);
    }

}
