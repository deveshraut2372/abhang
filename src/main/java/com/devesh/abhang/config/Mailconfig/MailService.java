package com.devesh.abhang.config.Mailconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MailService {


    @Autowired
    private JavaMailSender mailSender;

    Logger logger= LoggerFactory.getLogger(MailService.class);

    public void  sendMail(String to,String  subject, String body)
    {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(to);
            mailMessage.setSubject(subject);
            mailMessage.setText(body);
            mailMessage.setSentDate(new Date());
            mailMessage.setFrom("deveshraut2372000@gmail.com");
            mailSender.send(mailMessage);

            logger.info(" successfully send mail");
        }catch (Exception e)
        {
            logger.error( e.getMessage());
            e.printStackTrace();
        }
    }


}
