package com.benchmark.apireactive.application.controllers;

import com.benchmark.apireactive.domain.services.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send-emails-reactive")
    public Mono<ResponseEntity<String>> sendEmails(@RequestBody List<String> emails) {
        Flux<String> emailsFlux = Flux.fromIterable(emails);
        return emailService.sendEmails(emailsFlux)
                .then(Mono.just(ResponseEntity.ok("E-mails sent successfully")));
    }
}
