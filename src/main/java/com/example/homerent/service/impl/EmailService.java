package com.example.homerent.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public String sendEmail(String email, String subject, String body) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("stackflowover3@gmail.com");
            message.setTo(email);
            message.setText(body);
            message.setSubject(subject);

            javaMailSender.send(message);
            //  System.out.println("mail send");
            return "Mail Sent Successfully...";
        }
        catch (Exception e){
            return "error";

        }

    }
}
