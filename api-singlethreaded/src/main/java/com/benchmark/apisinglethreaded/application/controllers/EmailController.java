package com.benchmark.apisinglethreaded.application.controllers;

import com.benchmark.apisinglethreaded.domain.services.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send-emails-single-threaded")
    public ResponseEntity<String> sendEmails(@RequestBody List<String> emails) {
        emailService.sendEmails(emails);
        return ResponseEntity.ok("E-mails sent successfully");
    }
}
