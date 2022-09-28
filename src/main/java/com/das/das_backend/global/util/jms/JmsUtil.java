package com.das.das_backend.global.util.jms;

import com.das.das_backend.global.exception.SendCodeFailedException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RequiredArgsConstructor
@Component
public class JmsUtil {

    @Value("${spring.mail.username}")
    private String from;

    private final JavaMailSender javaMailSender;
    private final JmsProperties jmsProperties;

    public void sendEmail(String email, String code) {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,false,"UTF-8");

            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setFrom(jmsProperties.getUsername());
            mimeMessageHelper.setSubject("Das 이메일 인증");

            String text = "인증코드 : " + code;
            mimeMessageHelper.setText(text);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw SendCodeFailedException.EXCEPTION;
        }
    }

}
