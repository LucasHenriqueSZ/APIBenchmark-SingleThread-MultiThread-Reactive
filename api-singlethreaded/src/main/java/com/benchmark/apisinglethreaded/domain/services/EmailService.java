package com.benchmark.apisinglethreaded.domain.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    public void sendEmails(List<String> emailsList) {
        emailsList.forEach(this::sendEmail);
    }

    private void sendEmail(String email) {
        System.out.println("Sending email to: " + email);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
