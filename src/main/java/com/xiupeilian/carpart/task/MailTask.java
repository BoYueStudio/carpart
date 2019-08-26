package com.xiupeilian.carpart.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailTask implements Runnable {
    private JavaMailSenderImpl mailSender;
    private SimpleMailMessage mailMessage;


    public MailTask(JavaMailSenderImpl mailSender, SimpleMailMessage mailMessage) {
        this.mailSender = mailSender;
        this.mailMessage = mailMessage;
    }

    @Override
    public void run() {
        mailSender.send(mailMessage);

    }
}
