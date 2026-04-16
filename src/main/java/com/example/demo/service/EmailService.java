package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    // @Async means this runs in a SEPARATE thread
    // so it doesn't block the main request
    @Async
    public void sendEmail(String toEmail,
                          String subject,
                          String body) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
        System.out.println("Email sent to: " + toEmail);
    }

    // Send welcome email after registration
    @Async
    public void sendWelcomeEmail(String toEmail, String username) {
        sendEmail(
                toEmail,
                "Welcome to MyApp!",
                "Hi " + username + ",\n\n" +
                        "Thank you for registering!\n\n" +
                        "Best regards,\nMyApp Team"
        );
    }
}