package com.benchmark.apimultithreading.domain.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class EmailService {

    public CompletableFuture<Void> sendEmails(List<String> emailsList) {
        List<CompletableFuture<Void>> futures = emailsList.stream()
                .map(this::sendEmail)
                .collect(Collectors.toList());

        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    }

    @Async
    public CompletableFuture<Void> sendEmail(String email) {
        return CompletableFuture.runAsync(() -> {
            System.out.println("Sending email to: " + email);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

}
