package com.das.das_backend.global.util.jms;

import com.das.das_backend.global.exception.SendCodeFailedException;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RequiredArgsConstructor
@Component
public class JmsUtil {

    private final JavaMailSender javaMailSender;
    private final JmsProperties jmsProperties;

    public void sendEmail(String email, String code) {

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, false, "UTF-8");

            messageHelper.setTo(email);
            messageHelper.setFrom(jmsProperties.getUsername());
            messageHelper.setSubject("[Das] 이메일 인증");

            String text = "인증코드 : " + code;
            messageHelper.setText(text);

             javaMailSender.send(message);
        } catch (MessagingException e) {
            throw SendCodeFailedException.EXCEPTION;
        }
    }

}
