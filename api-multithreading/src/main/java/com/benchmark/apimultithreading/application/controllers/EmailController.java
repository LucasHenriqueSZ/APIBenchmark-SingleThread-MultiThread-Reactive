package com.benchmark.apimultithreading.application.controllers;

import com.benchmark.apimultithreading.domain.services.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send-emails-multi-threaded")
    public ResponseEntity<String> sendEmails(@RequestBody List<String> emails) {
        CompletableFuture<Void> future = emailService.sendEmails(emails);
        future.join();
        return ResponseEntity.ok("E-mails are being sent asynchronously");
    }
}
