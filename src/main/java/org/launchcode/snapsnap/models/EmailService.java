package org.launchcode.snapsnap.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;


    public String sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("musaddiqmanzoor4@gmail.com");
        message.setTo("musaddiqmanzoor4@gmail.com");
        message.setSubject("Test Subject");
        message.setText("Test Body");
        javaMailSender.send(message);

        return "<!DOCTYPE html>\n" +
                "<html xmlns:th=\"http://www.thymeleaf.org/\"\n" +
                "      xmlns:sec=\"https://www.thymeleaf.org/thymeleaf-extras-springsecurity5:3.0.4.RELEASE\">\n" +
                "<head th:replace=\"fragments :: head\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<div th:replace=\"fragments :: page-header\"></div>\n" +
                "<div class=\"container body-content\">\n" +
                "\n" +
                "    <div>\n" +
                "        Email sent, please check your inbox.</b>\n" +
                "        <h4>Thank you so much for shopping with us!</h4>\n" +
                "        <p>We are preparing your fav drink, our rider will be around the corner soon.</p>\n" +
                "        <p>Enjoy your drink, have a good time.</p>\n" +
                "        <h4>We hope to see you again soon!</h4>\n" +
                "    </div>\n" +
                "\n" +
                "    <a href=\"/index\">Want to shop more?</a>\n" +
                "\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";
    }

}
