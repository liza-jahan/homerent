package com.example.homerent.service.impl;


import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String email, String subject, String body) {

        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("eaktekerjahan@gmail.com");
        message.setTo(email);
        message.setText(body);
        message.setSubject(subject);

        javaMailSender.send(message);
        
    }
}
