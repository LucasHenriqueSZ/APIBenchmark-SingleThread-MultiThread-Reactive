package com.benchmark.apireactive.domain.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class EmailService {

    public Mono<Void> sendEmails(Flux<String> emailsList) {
        return emailsList
                .flatMap(this::sendEmail)
                .then();
    }

    private Mono<Void> sendEmail(String email) {
        return Mono.delay(Duration.ofSeconds(4))
                .doOnNext(tick -> System.out.println("Sending email to: " + email))
                .then();
    }
}
