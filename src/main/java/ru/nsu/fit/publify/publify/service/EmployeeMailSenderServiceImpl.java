package ru.nsu.fit.publify.publify.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeMailSenderServiceImpl implements EmployeeMailSenderService {
    private final JavaMailSender mailSender;

    @Override
    public void sendRegistrationEmail(String email, String password) {
        String text = String.join("\n",
            "Добрый день!\n",
            "Мы поздравляем вас с тем, что вы успешно зарегистрировались на нашем сервисе! Высылаем вам ваши логин и пароль.",
            "Логин: %s".formatted(email),
            "Пароль: %s".formatted(password),
            "\nС уважением и заботой, команда Publify."
        );
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("Publify");
        message.setTo(email);
        message.setSubject("Вы успешно зарегистрировались!");
        message.setText(text);
        mailSender.send(message);
    }


}
